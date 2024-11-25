//
//  AddViewController.swift
//  FiveMinutes
//
//  Created by MaeulTalk on 2024/11/11.
//

import UIKit
import FirebaseFirestore
import FirebaseStorage
import SDWebImage
import Toast

class AddViewController: UIViewController, UIImagePickerControllerDelegate, UINavigationControllerDelegate {
    var context: Context?
    var isImageChanged: Bool = false // 이미지가 변경되었는지 체크
    
    @IBOutlet weak var contextField: UITextField!
    @IBOutlet weak var imageView: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        if let context = context {
            // 기존 Context가 있을 경우, 텍스트 필드에 제목 설정
            contextField.text = context.title
            
            // 기존 이미지 URL이 있다면 이미지를 불러옴
            if let imageUrl = context.imageUrl {
                imageView.sd_setImage(with: URL(string: imageUrl), for: .normal, completed: nil)
            }
        }
    }

    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
    }

    @IBAction func saveContext(_ sender: UIBarButtonItem) {
        guard let title = contextField.text, !title.isEmpty else {
            self.view.makeToast("할 일을 입력해주세요.", duration: 2.0, position: .bottom)
            return // 텍스트 필드가 비어 있으면 저장하지 않음
        }
        
        if var context = context {
            // 기존 Context 객체 수정
            context.title = title

            // 이미지를 수정했으면 업로드 및 Firestore 업데이트
            if isImageChanged {
                if let image = imageView.image(for: .normal) {
                    uploadImage(image) { [weak self] url in
                        guard let self = self else { return }
                        
                        if let url = url {
                            // 기존 이미지 URL이 있다면 스토리지에서 삭제
                            if let oldImageUrl = context.imageUrl {
                                self.deleteImageFromStorage(imageUrl: oldImageUrl)
                            }
                            context.imageUrl = url
                            self.updateContext(context) // 이미지 URL을 업데이트한 후 context 수정
                        }
                    }
                }
            } else {
                // 이미지가 변경되지 않았다면, 기존의 이미지 URL 그대로 사용
                updateContext(context)
            }
        } else {
            // 새 Context 객체 추가
            let newContext = Context(title: title, id: nil)
            addContext(newContext)
        }
    }
    
    func uploadImage(_ image: UIImage, completion: @escaping (String?) -> Void) {
        let storageRef = storage.reference().child("images/\(UUID().uuidString).jpg")
        
        if let imageData = image.jpegData(compressionQuality: 0.8) {
            storageRef.putData(imageData, metadata: nil) { metadata, error in
                if let error = error {
                    print("Error uploading image: \(error)")
                    completion(nil)
                    return
                }
                
                // 이미지의 다운로드 URL 가져오기
                storageRef.downloadURL { url, error in
                    if let error = error {
                        print("Error getting download URL: \(error)")
                        completion(nil)
                    } else {
                        completion(url?.absoluteString)
                    }
                }
            }
        } else {
            print("Error converting image to data")
            completion(nil)
        }
    }
    
    // MARK: 파이어베이스
    
    let db = Firestore.firestore()
    let storage = Storage.storage()
    
    // Firestore에 새로운 Context 추가
    func addContext(_ context: Context) {
        let db = Firestore.firestore()
        
        db.collection("contexts").addDocument(data: context.toDictionary()) { error in
            if let error = error {
                print("Error adding document: \(error)")
            } else {
                print("Document successfully added!")
                self.navigationController?.popViewController(animated: true)
            }
        }
    }
    
    // Firestore에서 기존 Context 수정
    func updateContext(_ context: Context) {
        guard let id = context.id else { return }
        
        let db = Firestore.firestore()
        var contextData = context.toDictionary()
        
        // 기존 이미지 URL이 변경되었으면 이미지 URL도 포함
        if let imageUrl = context.imageUrl {
            contextData["imageUrl"] = imageUrl
        }
        
        db.collection("contexts").document(id).updateData(contextData) { error in
            if let error = error {
                print("Error updating document: \(error)")
            } else {
                print("Document successfully updated!")
                self.navigationController?.popViewController(animated: true)
            }
        }
    }
    
    // MARK: 이미지 관련
    
    @IBAction func selectImage(_ sender: UIButton) {
        let imagePickerController = UIImagePickerController()
        imagePickerController.delegate = self
        
        // 카메라나 앨범을 선택할 수 있도록 옵션 추가
        let actionSheet = UIAlertController(title: "사진 선택", message: "사진을 선택하세요", preferredStyle: .actionSheet)
        
        actionSheet.addAction(UIAlertAction(title: "카메라", style: .default, handler: { [weak self] _ in
            if UIImagePickerController.isSourceTypeAvailable(.camera) {
                imagePickerController.sourceType = .camera
                self?.present(imagePickerController, animated: true, completion: nil)
            } else {
                self?.showAlert("카메라가 사용 불가한 기기입니다.")
            }
        }))
        
        actionSheet.addAction(UIAlertAction(title: "앨범", style: .default, handler: { [weak self] _ in
            imagePickerController.sourceType = .photoLibrary
            self?.present(imagePickerController, animated: true, completion: nil)
        }))
        
        actionSheet.addAction(UIAlertAction(title: "취소", style: .cancel, handler: nil))
        
        self.present(actionSheet, animated: true, completion: nil)
    }

    // UIImagePickerControllerDelegate 구현: 이미지를 선택한 후 호출됩니다.
    func imagePickerController(_ picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [UIImagePickerController.InfoKey : Any]) {
        if let selectedImage = info[.originalImage] as? UIImage {
            imageView.setImage(selectedImage, for: .normal)  // 선택한 이미지를 이미지뷰에 설정
        }
        picker.dismiss(animated: true, completion: nil)
    }
    
    func imagePickerControllerDidCancel(_ picker: UIImagePickerController) {
        picker.dismiss(animated: true, completion: nil)
    }
    
    private func showAlert(_ message: String) {
        let alert = UIAlertController(title: "오류", message: message, preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "확인", style: .default, handler: nil))
        present(alert, animated: true, completion: nil)
    }
    
    // MARK: 이미지 삭제 - Firebase Storage에서 기존 이미지 삭제
    func deleteImageFromStorage(imageUrl: String) {
        let storageRef = Storage.storage().reference(forURL: imageUrl)
        
        // 기존 이미지 삭제
        storageRef.delete { error in
            if let error = error {
                print("Error deleting image: \(error.localizedDescription)")
            } else {
                print("Image successfully deleted from storage!")
            }
        }
    }
}

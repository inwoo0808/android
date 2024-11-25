//
//  AddTodoViewController.swift
//  TodoManaging
//
//  Created by MaeulTalk on 2024/11/19.
//

import UIKit

class AddTodoViewController: UIViewController, UIImagePickerControllerDelegate, UINavigationControllerDelegate {
    
    @IBOutlet weak var todoName: UITextField!
    @IBOutlet weak var buttonImage: UIButton!
    var selectedImage: String?
    
    override func viewDidLoad() {
        super.viewDidLoad()

    }

    @IBAction func getImage(_ sender: UIButton) {
        // UIImagePickerController를 사용하여 사진 앨범을 열기
        let imagePickerController = UIImagePickerController()
        imagePickerController.delegate = self
        imagePickerController.sourceType = .photoLibrary  // 앨범에서 이미지 선택
        imagePickerController.allowsEditing = true  // 선택한 이미지 편집 가능하게 설정 (선택 사항)
        
        // 사진 앨범 열기
        present(imagePickerController, animated: true, completion: nil)
    }
    
    // UIImagePickerControllerDelegate에서 이미지 선택 후 호출되는 메서드
    func imagePickerController(_ picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [UIImagePickerController.InfoKey : Any]) {
        // 선택한 이미지 가져오기
        if let selectedImage = info[UIImagePickerController.InfoKey.editedImage] as? UIImage {
            self.selectedImage = "selectedImage"
            buttonImage.setImage(selectedImage, for: .normal)  // 버튼에 선택한 이미지 설정
        }
        
        // UIImagePickerController 닫기
        picker.dismiss(animated: true, completion: nil)
    }
    
    // 취소 버튼 클릭 시 호출되는 메서드 (선택 사항)
    func imagePickerControllerDidCancel(_ picker: UIImagePickerController) {
        picker.dismiss(animated: true, completion: nil)
    }
    
    @IBAction func addTodo(_ sender: UIBarButtonItem) {
        let todoManager = TodoManager()
        let todo = Todo(name: "Buy groceries", image: "")
        todoManager.saveTodo(todo: todo) { error in
            if let error = error {
                print("Todo 저장 실패: \(error.localizedDescription)")
            } else {
                print("Todo 저장 성공")
            }
        }
        
        if let name = todoName.text, !name.isEmpty, let selectedImage = selectedImage {
            let todo = Todo(name: name, image: selectedImage)  // 새로운 Todo 객체 생성
            if let viewController = presentingViewController as? ViewController {
//                viewController.addNewTodo(todo)  // ViewController에 todo 추가
            }
            navigationController?.popViewController(animated: true)  // ViewController로 돌아가기
        } else {
            let alert = UIAlertController(title: "Error", message: "Please enter a Todo name and select an image.", preferredStyle: .alert)
            alert.addAction(UIAlertAction(title: "OK", style: .default, handler: nil))
            present(alert, animated: true, completion: nil)
        }
    }
}

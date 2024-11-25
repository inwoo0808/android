//
//  showTodoViewController.swift
//  TodoManaging
//
//  Created by MaeulTalk on 2024/11/19.
//

import UIKit
import FirebaseFirestore

class ShowTodoViewController: UIViewController {
    // 데이터를 받을 변수 선언
    var todo: Todo?
    
    let db = Firestore.firestore()

    @IBOutlet weak var labelTodo: UILabel!
    @IBOutlet weak var imageViewTodo: UIImageView!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // 전달받은 데이터 출력
        if let todo = todo {
            labelTodo.text = todo.name
//            imageViewTodo.image = todo.image
        }
    }
    
    @IBAction func deleteTodo(_ sender: UIBarButtonItem) {
        // Firestore에서 해당 문서 삭제
        db.collection("todos").document(todo!.id!).delete { error in
            if let error = error {
                print("Error deleting document: \(error)")
            } else {
                self.navigationController?.popViewController(animated: true)  // ViewController로 돌아가기
            }
        }
    }
    
}

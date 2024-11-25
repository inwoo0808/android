//
//  TodoManager.swift
//  TodoManaging
//
//  Created by MaeulTalk on 2024/11/20.
//

import Foundation
import FirebaseFirestore

class TodoManager {
    let db = Firestore.firestore()
    
    func saveTodo(todo: Todo, completion: @escaping (Error?) -> Void) {
        let todoData: [String: Any] = [
            "name": todo.name,
            "image": todo.image
        ]
        
        self.db.collection("todos").addDocument(data: todoData) { error in
            completion(error)
        }
    }
    
   
}

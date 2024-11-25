//
//  ViewController.swift
//  TodoManaging
//
//  Created by MaeulTalk on 2024/11/19.
//

import UIKit
import FirebaseFirestore
import FirebaseStorage

class ViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {
    @IBOutlet weak var tableView: UITableView!
    
    var todoList = [Todo]()
    let db = Firestore.firestore()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        tableView.dataSource = self
        tableView.delegate = self
    }
    
    override func viewWillAppear(_ animated: Bool) {
        fetchTodoList()  // Firestore에서 할일 목록을 가져옵니다.
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Segue Identifier 확인
        if segue.identifier == "showTodo" {
            // 이동할 ViewController 가져오기
            if let showTodoVC = segue.destination as? ShowTodoViewController {
                if let indexPath = tableView.indexPathForSelectedRow {
                    showTodoVC.todo = todoList[indexPath.row]
                }
            }
        }
    }
    
    // Firestore에서 할일 목록을 가져오는 메서드
    func fetchTodoList() {
        db.collection("todos").getDocuments { (querySnapshot, error) in
            if let error = error {
                print("Error getting documents: \(error)")
            } else {
                self.todoList = querySnapshot?.documents.compactMap { document -> Todo? in
                    let data = document.data()
                    guard let name = data["name"] as? String else { return nil }
                    let image = data["image"] as? String
                    return Todo(id: document.documentID, name: name, image: image)
                } ?? []
                self.tableView.reloadData()  // 테이블 뷰 리로드
            }
        }
    }
    
    // 테이블 뷰의 행 개수 설정
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return todoList.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: "todoCell", for: indexPath) as? TodoCell else {
            return UITableViewCell()
        }
        
        let todo = todoList[indexPath.row]
        cell.labelTodo.text = todo.name
        
        // Firebase Storage에서 이미지 URL 가져오기
        let storageRef = Storage.storage().reference()
        let imageRef = storageRef.child("images/\(todo.image)") // 예시로 'images/파일명' 경로
        
        // 이미지 다운로드
        imageRef.getData(maxSize: 1 * 1024 * 1024) { (data, error) in
            if let error = error {
                print("Error downloading image: \(error.localizedDescription)")
                return
            }
            
            if let data = data, let image = UIImage(data: data) {
                cell.imageViewTodo.image = image
            }
        }
        
        cell.imageViewTodo.layer.cornerRadius = 6 // 동그란 모양
        cell.imageViewTodo.clipsToBounds = true
        
        return cell
    }
}


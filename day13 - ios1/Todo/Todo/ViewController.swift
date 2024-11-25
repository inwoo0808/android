//
//  ViewController.swift
//  Todo
//
//  Created by MaeulTalk on 2024/11/01.
//

import UIKit

class ViewController: UIViewController, UITableViewDataSource {
    
    @IBOutlet weak var tableView: UITableView!
    @IBOutlet weak var textField: UITextField!
    
    // 메모를 저장할 배열
    var todoList: [String] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // 테이블뷰의 데이터 소스를 설정합니다.
        tableView.dataSource = self
    }
    
    @IBAction func addTodo(_ sender: UIButton) {
        guard let text = textField.text, !text.isEmpty else { return }
                
        // 메모를 배열에 추가하고 테이블뷰를 갱신합니다.
        todoList.append(text)
        tableView.reloadData()
        
        // 스크롤을 맨 아래로 이동
        let lastIndex = IndexPath(row: todoList.count - 1, section: 0)
        tableView.scrollToRow(at: lastIndex, at: .bottom, animated: true)
        
        // 텍스트필드를 비웁니다.
        textField.text = ""
    }
    
    // MARK: - UITableViewDataSource 메서드

    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return todoList.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "TodoCell", for: indexPath)
        cell.textLabel?.text = todoList[indexPath.row]
        return cell
    }
}


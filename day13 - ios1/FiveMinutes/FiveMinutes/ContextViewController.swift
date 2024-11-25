//
//  ContextViewController.swift
//  FiveMinutes
//
//  Created by MaeulTalk on 2024/11/09.
//

import UIKit
import FirebaseFirestore

class ContextViewController: UIViewController, UITableViewDataSource {

    @IBOutlet weak var tableView: UITableView!

    var contexts: [Context] = []  // Context 객체를 담을 배열
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        tableView.dataSource = self
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        loadContexts()  // 화면이 나타날 때마다 컨텍스트를 로드
    }
    
    func loadContexts() {
        let db = Firestore.firestore()
        db.collection("contexts")
            .order(by: "createdAt", descending: true)
            .getDocuments { snapshot, error in
                if let error = error {
                    print("Error getting documents: \(error)")
                } else {
                    if let documents = snapshot?.documents {
                        // 문서가 제대로 존재하는지 확인하고, 데이터를 모델로 변환하여 contexts 배열에 넣기
                        self.contexts = documents.compactMap { doc in
                            guard let title = doc["title"] as? String,
                                  let createdAt = doc["createdAt"] as? Timestamp else { return nil }
                            // Timestamp를 Date로 변환하여 사용
                            let imageUrl = doc["imageUrl"] as? String  // 이미지 URL 가져오기
                            return Context(title: title, id: doc.documentID, createdAt: createdAt.dateValue(), imageUrl: imageUrl)
                        }
                        
                        // 데이터가 제대로 로드되었는지 콘솔 로그로 확인
                        print("Loaded contexts: \(self.contexts)")
                        
                        self.tableView.reloadData()
                    }
                }
            }
    }

    // prepare(for:) 메서드에서 추가/수정 화면으로 넘어갈 때 데이터 전달
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if let destinationVC = segue.destination as? AddViewController {
            switch segue.identifier {
            case "addContextSegue":
                destinationVC.title = "할 일 등록"
            case "editContextSegue":
                if let indexPath = tableView.indexPathForSelectedRow {
                    destinationVC.title = "할 일 수정"
                    destinationVC.context = contexts[indexPath.row]
                }
            default:
                break
            }
        }
    }

    // MARK: 테이블뷰 데이터소스 메서드
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return contexts.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "contextCell", for: indexPath) as! CustomTableViewCell
        cell.contextLabel.text = contexts[indexPath.row].title  // Context의 title을 표시
        return cell
    }
}

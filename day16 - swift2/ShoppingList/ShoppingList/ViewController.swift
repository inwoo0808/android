//
//  ViewController.swift
//  ShoppingList
//
//  Created by MaeulTalk on 2024/11/14.
//

import UIKit

// ShoppingItem 프로토콜 정의
protocol ShoppingItem {
    var name: String { get }
    var price: String { get }
    func displayItemDetails() -> String
}

// Item 클래스 정의
class Item: ShoppingItem {
    var name: String
    var price: String
    
    init(name: String, price: String) {
        self.name = name
        self.price = price
    }
    
    func displayItemDetails() -> String {
        return "\(name): $\(price)"
    }
}

// GroceryItem 클래스 (식료품)
class GroceryItem: Item {
    var expirationDate: String
    
    init(name: String, price: String, expirationDate: String) {
        self.expirationDate = expirationDate
        super.init(name: name, price: price)
    }
    
    override func displayItemDetails() -> String {
        return "\(name) - \(price) (유통기한: \(expirationDate))"
    }
}

// ElectronicsItem 클래스 (전자제품)
class ElectronicsItem: Item {
    var warrantyDate: String
    
    init(name: String, price: String, warrantyDate: String) {
        self.warrantyDate = warrantyDate
        super.init(name: name, price: price)
    }
    
    override func displayItemDetails() -> String {
        return "\(name) - \(price) (보증기한: \(warrantyDate))"
    }
}

class ViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {
    var shoppingItems: [ShoppingItem] = []
    
    @IBOutlet weak var name: UITextField!
    @IBOutlet weak var price: UITextField!
    @IBOutlet weak var fieldExpiraition: UITextField!
    @IBOutlet weak var selectType: UIButton!
    @IBOutlet weak var tableView: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        tableView.dataSource = self
        tableView.delegate = self
        
        // 쇼핑 항목 추가
        shoppingItems.append(GroceryItem(name: "우유", price: "2,500원", expirationDate: "2024-12-31"))
        shoppingItems.append(ElectronicsItem(name: "이어폰", price: "15,000원", warrantyDate: "2024-11-21"))
        
        // 쇼핑 항목 출력
        for item in shoppingItems {
            print(item.displayItemDetails())
        }
    }
    
    @IBAction func selectType(_ sender: UIButton) {
        // UIAlertController 생성
        let alert = UIAlertController(title: "상품 종류 선택", message: nil, preferredStyle: .actionSheet)
        
        // 옵션 추가
        alert.addAction(UIAlertAction(title: "식재료", style: .default, handler: { _ in
            sender.setTitle("식재료", for: .normal)
            self.fieldExpiraition.placeholder = "유통기한"
        }))
        alert.addAction(UIAlertAction(title: "전자제품", style: .default, handler: { _ in
            sender.setTitle("전자제품", for: .normal)
            self.fieldExpiraition.placeholder = "보증기한"
        }))
        alert.addAction(UIAlertAction(title: "취소", style: .cancel, handler: nil))
        
        // iPad에서 Action Sheet가 올바르게 표시되도록 anchor 설정
        if let popoverController = alert.popoverPresentationController {
            popoverController.sourceView = sender
            popoverController.sourceRect = sender.bounds
        }
        
        // UIAlertController 표시
        present(alert, animated: true, completion: nil)
    }
    
    @IBAction func button(_ sender: UIButton) {
        if selectType.title(for: .normal) == "식재료" {
            shoppingItems.append(GroceryItem(name: name.text!, price: price.text!, expirationDate: fieldExpiraition.text!))
        } else if selectType.title(for: .normal) == "전자제품" {
            shoppingItems.append(ElectronicsItem(name: name.text!, price: price.text!, warrantyDate: fieldExpiraition.text!))
        }
        
        for item in shoppingItems {
            print(item.displayItemDetails())
        }
        
        tableView.reloadData()
        
        name.text = ""
        price.text = ""
        fieldExpiraition.text = ""
    }
    
    // MAKR: 테이블뷰
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return shoppingItems.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "itemCell", for: indexPath)
        cell.textLabel?.text = shoppingItems[indexPath.row].displayItemDetails()
        return cell
    }
}


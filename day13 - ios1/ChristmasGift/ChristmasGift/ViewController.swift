//
//  ViewController.swift
//  ChristmasGift
//
//  Created by MaeulTalk on 2024/11/13.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var name: UITextField!
    @IBOutlet weak var message: UITextField!
    @IBOutlet weak var imageView: UIImageView!
    @IBOutlet weak var datePicker: UIDatePicker!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        
    }

    @IBAction func buttonFlower(_ sender: UIButton) {
        imageView.image = UIImage(named: "flower")
    }
    
    @IBAction func buttonNecklace(_ sender: UIButton) {
        imageView.image = UIImage(named: "necklace")
    }
    
    @IBAction func buttonCar(_ sender: UIButton) {
        imageView.image = UIImage(named: "car")
    }
    
    @IBAction func buttonComplete(_ sender: UIButton) {
        // 선택된 날짜와 시간 가져오기
        let selectedDate = datePicker.date
        
        // DateFormatter를 사용하여 날짜와 시간 포맷
        let formatter = DateFormatter()
        formatter.dateStyle = .medium // 날짜 스타일 설정
        formatter.timeStyle = .short // 시간 스타일 설정
        
        let formattedDate = formatter.string(from: selectedDate)
        
        // UIAlertController 생성
        let alertController = UIAlertController(
            title: "\(name.text!)에게 선물이 배송됩니다.",
            message: "메세지: \(message.text!)\n배송 날짜: \(formattedDate)",
            preferredStyle: .alert
        )
        
        // OK 버튼 추가
        let okAction = UIAlertAction(title: "확인", style: .default, handler: nil)
        alertController.addAction(okAction)
        
        // 알림 표시
        self.present(alertController, animated: true, completion: nil)
    }
}


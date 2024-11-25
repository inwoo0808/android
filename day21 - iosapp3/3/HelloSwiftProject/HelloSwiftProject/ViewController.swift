//
//  ViewController.swift
//  HelloSwiftProject
//
//  Created by MaeulTalk on 2024/11/05.
//

// 시뮬레이터 크기 바꾸기
// 시뮬레이터 바꿔보기
// 실행 단축키 사용하기
// 시뮬레이터 키보드 사용해보기


import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var valueLable: UILabel!
    
    @IBOutlet weak var inputField: UITextField!
    
    // 잘못된 연결 코드 지우고 다시 연결 해제 후 다시 연결하기
    @IBAction func showValue(_ sender: UIButton) {
        let name = inputField.text!
        valueLable.text = "Hello, \(name)"
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}


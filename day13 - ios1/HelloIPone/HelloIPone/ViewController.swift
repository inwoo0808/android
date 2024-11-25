//
//  ViewController.swift
//  HelloIPone
//
//  Created by MaeulTalk on 2024/11/19.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var lable: UILabel!
    @IBOutlet weak var name: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func send(_ sender: UIButton) {
        lable.text = "Hello, " + name.text!
    }
    
}


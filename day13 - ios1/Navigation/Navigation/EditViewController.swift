//
//  EditViewController.swift
//  Navigation
//
//  Created by MaeulTalk on 2024/11/08.
//

import UIKit

protocol EditDelegate {
    func didMessageEditDone(_ controller: EditViewController, message: String)
}

class EditViewController: UIViewController {
    var textWayValue = ""
    var textMessage = ""
    var delegate: EditDelegate?
    
    @IBOutlet weak var lblWay: UILabel!
    @IBOutlet weak var txMessage: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        lblWay.text = textWayValue
    }
    
    @IBAction func btnDone(_ sender: UIButton) {
        if delegate != nil {
            delegate?.didMessageEditDone(self, message: txMessage.text!)
        }
        
        _ = navigationController?.popViewController(animated: true)
    }
}

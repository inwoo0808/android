//
//  ViewController.swift
//  Navigation
//
//  Created by MaeulTalk on 2024/11/08.
//

import UIKit

class ViewController: UIViewController, EditDelegate {
    @IBOutlet weak var txMessage: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let editViewController = segue.destination as! EditViewController
        if segue.identifier == "editButton" {
            editViewController.textWayValue = "segue: use button"
        } else if segue.identifier == "editBarButton" {
            editViewController.textWayValue = "segue: use bar button"
        }
        editViewController.textMessage = txMessage.text!
        editViewController.delegate = self
    }

    func didMessageEditDone(_ controller: EditViewController, message: String) {
        txMessage.text = message
    }
}


//
//  ViewController.swift
//  Contact
//
//  Created by MaeulTalk on 2024/11/14.
//

import UIKit

class ViewController: UIViewController {
    var contacts = [(String, String)]()
    
    @IBOutlet weak var name: UITextField!
    @IBOutlet weak var phone: UITextField!
    @IBOutlet weak var nameSearch: UITextField!
    @IBOutlet weak var label: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    @IBAction func button(_ sender: UIButton) {
        contacts.append((name.text!, phone.text!))
        print(contacts)
        name.text = ""
        phone.text = ""
    }
    
    @IBAction func buttonSearch(_ sender: UIButton) {
        let found = findContact(name: name.text!)
        label.text = found
    }
    
    func findContact(name: String) -> String {
        for contact in contacts {
            if contact.0 == nameSearch.text! {
                return contact.1
            }
        }
        return "Contact not found"
    }
}


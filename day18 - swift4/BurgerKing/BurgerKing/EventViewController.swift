//
//  EventViewController.swift
//  BurgerKing
//
//  Created by MaeulTalk on 2024/11/14.
//

import UIKit
import WebKit

class EventViewController: UIViewController {
    @IBOutlet weak var webView: WKWebView!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        loadWebPage("https://www.burgerking.co.kr/#/event/0/1")
    }

    func loadWebPage(_ url: String) {
        let myUrl = URL(string: url)
        let myRequest = URLRequest(url: myUrl!)
        webView.load(myRequest)
    }
}

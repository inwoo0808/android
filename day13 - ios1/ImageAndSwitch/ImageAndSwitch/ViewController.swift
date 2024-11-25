//
//  ViewController.swift
//  ImageAndSwitch
//
//  Created by MaeulTalk on 2024/11/07.
//

import UIKit

class ViewController: UIViewController {
    var zoom = false
    
    let imageOff: UIImage? = UIImage(named: "lamp_off.png")
    let imageOn: UIImage? = UIImage(named: "lamp_on.png")
    
    @IBOutlet weak var imageView: UIImageView!
    
    @IBAction func button(_ sender: UIButton) {
        let scale: CGFloat = 2.0
        var width = imageView.frame.width
        var height = imageView.frame.height
        if !zoom {
            width *= scale
            height *= scale
            sender.setTitle("축소", for: .normal)
        } else {
            width /= scale
            height /= scale
            sender.setTitle("확대", for: .normal)
        }
        imageView.frame.size = CGSize(width: width, height: height)
        zoom = !zoom
    }
    @IBAction func switchOnOff(_ sender: UISwitch) {
        if sender.isOn {
            print("isOn")
            imageView.image = imageOn
        } else {
            print("isOff")
            imageView.image = imageOff
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        imageView.image = imageOn
        
    }
}


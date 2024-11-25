//
//  ViewController.swift
//  DateTimePicker
//
//  Created by MaeulTalk on 2024/11/07.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var currentTime: UILabel!
    @IBOutlet weak var pickerTime: UILabel!
    
    var timeSelector: Selector = #selector(ViewController.updateTime)
    let interval = 1.0
    var count = 0
    
    @IBAction func datePicker(_ sender: UIDatePicker) {
        let dateFormatter = DateFormatter()
        dateFormatter.dateFormat = "yyyy-MM-dd HH:mm:ss EEE"
        pickerTime.text = "선택 시간: " + dateFormatter.string(from: sender.date)
    }
    
    @objc func updateTime() {
//        currentTime.text = String(count)
//        count += 1
        
        var date = NSDate()
        
        let dateFormatter = DateFormatter()
        dateFormatter.dateFormat = "yyyy-MM-dd HH:mm:ss EEE"
        currentTime.text = "현재 시간: " + dateFormatter.string(from: date as Date)
    }

    override func viewDidLoad() {
        super.viewDidLoad()
        
        Timer.scheduledTimer(timeInterval: interval, target: self, selector: timeSelector, userInfo: nil, repeats: true)
    }
}


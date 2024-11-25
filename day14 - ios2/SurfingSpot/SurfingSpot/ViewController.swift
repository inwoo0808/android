//
//  ViewController.swift
//  SurfingSpot
//
//  Created by MaeulTalk on 2024/11/13.
//

import UIKit

class ViewController: UIViewController {
    let images = ["surfing1", "surfing2", "surfing3"]
    
    @IBOutlet weak var imageView: UIImageView!
    @IBOutlet weak var pageControl: UIPageControl!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        pageControl.numberOfPages = images.count
        pageControl.currentPage = 0
        pageControl.currentPageIndicatorTintColor = UIColor.red
        imageView.image = UIImage(named: images[pageControl.currentPage])
        
        let swipeLeft = UISwipeGestureRecognizer(target: self, action: #selector(handleSwipe(_:)))
        swipeLeft.direction = .left
        view.addGestureRecognizer(swipeLeft)
        
        let swipeRight = UISwipeGestureRecognizer(target: self, action: #selector(handleSwipe(_:)))
        swipeRight.direction = .right
        view.addGestureRecognizer(swipeRight)
    }

    @IBAction func pageChange(_ sender: UIPageControl) {
        imageView.image = UIImage(named: images[pageControl.currentPage])
    }
    
    @objc func handleSwipe(_ gesture: UISwipeGestureRecognizer) {
        if gesture.direction == .right {
            if pageControl.currentPage != 0 {
                pageControl.currentPage -= 1
                imageView.image = UIImage(named: images[pageControl.currentPage])
            }
        } else if gesture.direction == .left {
            if pageControl.currentPage != images.count - 1 {
                pageControl.currentPage += 1
                imageView.image = UIImage(named: images[pageControl.currentPage])
            }
        }
    }
}


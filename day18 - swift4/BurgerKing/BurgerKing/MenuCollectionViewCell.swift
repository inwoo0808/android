//
//  MenuCollectionViewCell.swift
//  BurgerKing
//
//  Created by MaeulTalk on 2024/11/15.
//

import UIKit

// 1. 제네릭을 사용한 UICollectionViewCell
class MenuCollectionViewCell<T: Item>: UICollectionViewCell {
    @IBOutlet weak var imageView: UIImageView!
    @IBOutlet weak var label: UILabel!
    
    // 데이터 모델을 설정하는 메소드
    func configure(with model: T) {
        if let menu = model as? Menu {
            imageView.image = UIImage(named: menu.image)
            imageView.backgroundColor = .orange
            label.text = menu.name
        } else if let menu = model as? Beverage {
            imageView.image = UIImage(named: menu.image)
            label.text = "음료 " + menu.name
        }
    }
}

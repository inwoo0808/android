//
//  ViewController.swift
//  BurgerKing
//
//  Created by MaeulTalk on 2024/11/14.
//

import UIKit

class ViewController: UIViewController, UICollectionViewDataSource, UICollectionViewDelegateFlowLayout {
    let menus = [
        Menu(name: "와퍼", image: "burger0"),
        Menu(name: "오리지널스 화이트 페타", image: "burger1"),
        Menu(name: "트러플 머쉬룸 와퍼", image: "burger2"),
        Menu(name: "치즈와퍼", image: "burger3"),
        Menu(name: "통새우와퍼", image: "burger4"),
        Menu(name: "두툼버거", image: "burger5"),
        Menu(name: "딥 트러플 프라이", image: "dessert1"),
        Menu(name: "바삭킹", image: "dessert2"),
//        Menu(name: "예외", image: ""),
        Beverage(name: "콜라", image: "coke"),
        Beverage(name: "사이다", image: "sider")
    ]
    
    @IBOutlet var collectionView: UICollectionView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // 컬렉션 뷰 레이아웃 설정
        let layout = UICollectionViewFlowLayout()
        layout.minimumInteritemSpacing = 10 // 아이템 간 간격
        layout.minimumLineSpacing = 10 // 줄 간 간격

        // 컬렉션 뷰 초기화 및 설정
        collectionView = UICollectionView(frame: self.view.bounds, collectionViewLayout: layout)
        collectionView.backgroundColor = .white
        collectionView.dataSource = self
        collectionView.delegate = self

        // 커스텀 셀 등록 (UICollectionViewCell -> MenuCollectionViewCell로 변경)
//        collectionView.register(MenuCollectionViewCell.self, forCellWithReuseIdentifier: "menuCell")
//        collectionView.register(MenuCollectionViewCell<Item>.self, forCellWithReuseIdentifier: "menuCell")

        // 뷰에 컬렉션 뷰 추가
//        self.view.addSubview(collectionView)
    }

    // MARK: - UICollectionViewDataSource

    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return menus.count // 예제 아이템 수
    }

    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "menuCell", for: indexPath) as! MenuCollectionViewCell<Item>
        
//        cell.imageView.image = UIImage(named: menus[indexPath.row].image)
        cell.configure(with: menus[indexPath.row])
        // 이미지 로드 시 예외 처리
//        do {
//            let image = try UIImage.load(named: menus[indexPath.row].image)
//            cell.imageView.image = image
//        } catch {
//            print("Error loading image: \(error)")
//            cell.imageView.image = UIImage(named: "defaultImage") // 대체 이미지 사용
//        }
        
        cell.label.text = menus[indexPath.row].name
        
        return cell
    }

    // MARK: - UICollectionViewDelegateFlowLayout

    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        let padding: CGFloat = 10 // 아이템 간의 간격
        let totalSpacing = padding * (2 - 1) // 두 개의 셀 기준 간격

        // 컬렉션뷰 너비에서 간격을 제외한 나머지를 셀의 너비로 사용
        let width = (collectionView.frame.width - totalSpacing) / 2
        return CGSize(width: width, height: width) // 정사각형 셀
    }
    
}

// UIImage Extension: 이미지를 안전하게 로드하는 메서드 추가
extension UIImage {
    // 이미지 이름을 통해 이미지를 로드하고 실패하면 오류를 던짐
    static func load(named imageName: String) throws -> UIImage? {
        guard let image = UIImage(named: imageName) else {
            throw ImageError.imageNotFound
        }
        return image
    }
    
    // 이미지가 없을 경우 던질 오류 정의
    enum ImageError: Error {
        case imageNotFound
    }
}

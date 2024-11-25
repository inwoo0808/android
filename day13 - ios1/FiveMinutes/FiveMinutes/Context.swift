//
//  Context.swift
//  FiveMinutes
//
//  Created by MaeulTalk on 2024/11/11.
//

import Foundation
import FirebaseFirestore

class Context {
    var title: String
    var id: String?
    var createdAt: Date
    var imageUrl: String?
    
    init(title: String, id: String?, createdAt: Date = Date(), imageUrl: String? = nil) {
        self.title = title
        self.id = id
        self.createdAt = createdAt
        self.imageUrl = imageUrl
    }
    
    func toDictionary() -> [String: Any] {
        var dictionary: [String: Any] = [
            "title": title,
            "createdAt": Timestamp(date: createdAt)  // Firestore에 저장할 수 있도록 변환
        ]
        
        if let imageUrl = imageUrl {
            dictionary["imageUrl"] = imageUrl  // 이미지 URL이 있으면 추가
        }
        
        return dictionary
    }
    
    convenience init?(document: [String: Any], id: String) {
        guard let title = document["title"] as? String,
              let timestamp = document["createdAt"] as? Timestamp else {
            return nil
        }
        let imageUrl = document["imageUrl"] as? String
        self.init(title: title, id: id, createdAt: timestamp.dateValue(), imageUrl: imageUrl)
    }
}


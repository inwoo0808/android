//
//  Memo.swift
//  SwiftUIMemo3
//
//  Created by MaeulTalk on 2024/11/04.
//

import Foundation

class Memo: Identifiable, ObservableObject {
    let id: UUID
    @Published var content: String
    var insertDate: Date
    
    init(content: String, insertDate: Date = Date.now) {
        id = UUID()
        self.content = content
        self.insertDate = insertDate
    }
}

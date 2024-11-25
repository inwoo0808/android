//
//  MemoStore.swift
//  SwiftUIMemo3
//
//  Created by MaeulTalk on 2024/11/04.
//

import Foundation

class MemoStore: ObservableObject {
    @Published var list: [Memo]
    
    init() {
        list = [
            Memo(content: "안녕", insertDate: Date.now),
            Memo(content: "방가", insertDate: Date.now.addingTimeInterval(3600 * -24)),
            Memo(content: "샬롬", insertDate: Date.now.addingTimeInterval(3600 * -48))
        ]
    }
    
    func insert(memo: String) {
        list.insert(Memo(content: memo), at: 0)
    }
    
    func update(memo: Memo?, content: String) {
        guard let memo = memo else {
            return
        }
        memo.content = content
        memo.insertDate = Date.now
    }
    
    func delete(memo: Memo) {
        list.removeAll() { $0.id == memo.id }
    }
    
    func delete(set: IndexSet) {
        for index in set {
            list.remove(at: index)
        }
    }
}

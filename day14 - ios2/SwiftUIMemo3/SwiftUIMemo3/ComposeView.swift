//
//  ComposeView.swift
//  SwiftUIMemo3
//
//  Created by MaeulTalk on 2024/11/05.
//

import SwiftUI

struct ComposeView: View {
    @EnvironmentObject var store: MemoStore
    var memo: Memo? = nil
    
    @State private var content: String = ""
    
    @Environment(\.dismiss) var dismiss
    
    var body: some View {
        NavigationView {
            VStack {
                TextEditor(text: $content)
                    .padding()
                    .onAppear {
                        if let memo = memo {
                            content = memo.content
                        }
                    }
            }
            .navigationTitle(memo != nil ? "메모 수정" : "새 메모")
            .navigationBarTitleDisplayMode(.inline)
            .toolbar {
                ToolbarItemGroup(placement: .navigationBarLeading) {
                    Button {
                        dismiss()
                    } label: {
                        Text("취소")
                    }

                }
                
                ToolbarItemGroup(placement: .navigationBarTrailing) {
                    Button {
                        if let memo = memo {
                            // 메모가 nil이 아니면 -> 수정 -> 업데이트
                            store.update(memo: memo, content: content)
                        } else {
                            // 메모가 nil이면 -> 새로 등록
                            store.insert(memo: content)
                        }
                        dismiss()
                    } label: {
                        Text("저장")
                    }

                }
            }
        }
    }
}

struct ComposeView_Previews: PreviewProvider {
    static var previews: some View {
        ComposeView()
            .environmentObject(MemoStore())
    }
}

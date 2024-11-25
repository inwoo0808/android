//
//  MainView.swift
//  SwiftUIMemo3
//
//  Created by MaeulTalk on 2024/11/05.
//

import SwiftUI

struct MainView: View {
    @EnvironmentObject var store: MemoStore
    
    @State private var showCompser = false
    
    var body: some View {
        NavigationView {
            List {
                ForEach(store.list) { memo in
                    NavigationLink {
                        DetailView(memo: memo)
                    } label: {
                        MemoCell(memo: memo)
                    }
                }
                .onDelete(perform: store.delete)
            }
            .listStyle(.plain)
            .navigationTitle("내 메모")
            .toolbar {
                Button {
                    showCompser = true
                } label: {
                    Image(systemName: "plus")
                }
            }
            .sheet(isPresented: $showCompser) {
                ComposeView()
            }
        }
    }
}

struct MainView_Previews: PreviewProvider {
    static var previews: some View {
        MainView()
            .environmentObject(MemoStore())
    }
}

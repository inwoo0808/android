//
//  ContentView.swift
//  SwiftUIMemo2
//
//  Created by MaeulTalk on 2024/11/04.
//

import SwiftUI

struct MainView: View {
    var body: some View {
        NavigationView {
            List {
                VStack(alignment: .leading) {
                    Text("Test")
                        .font(.body)
                    Text(Date.now, style: .date)
                        .font(.caption)
                        .foregroundColor(.secondary)
                }
                Text("Test")
                Text("Test")
            }
            .listStyle(.plain)
            .navigationTitle("내 메모")
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        MainView()
    }
}

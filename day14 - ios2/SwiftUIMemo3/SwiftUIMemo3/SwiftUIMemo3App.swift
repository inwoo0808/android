//
//  SwiftUIMemo3App.swift
//  SwiftUIMemo3
//
//  Created by MaeulTalk on 2024/11/04.
//

import SwiftUI

@main
struct SwiftUIMemo3App: App {
    let persistenceController = PersistenceController.shared
    @StateObject var store = MemoStore()

    var body: some Scene {
        WindowGroup {
            MainView()
                .environment(\.managedObjectContext, persistenceController.container.viewContext)
                .environmentObject(store)
        }
    }
}

//
//  SocialMediaApp.swift
//  SocialMedia
//
//  Created by MaeulTalk on 2024/11/12.
//

import SwiftUI
import FirebaseCore

@main
struct SocialMediaApp: App {
    init() {
        FirebaseApp.configure()
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}

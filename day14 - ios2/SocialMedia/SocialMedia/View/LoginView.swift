//
//  LoginView.swift
//  SocialMedia
//
//  Created by MaeulTalk on 2024/11/12.
//

import SwiftUI
import PhotosUI

struct LoginView: View {
    @State var email: String = ""
    @State var password: String = ""
    @State var createAccount: Bool = false
    
    var body: some View {
        VStack(spacing: 10) {
            Text("Let's sign you in")
                .font(.largeTitle.bold())
                .hAlign(.leading)
            Text("Welcome back,\nYou have been missed")
                .font(.title3)
                .hAlign(.leading)
            VStack(spacing: 12) {
                TextField("Email", text: $email)
                    .textContentType(.emailAddress)
                    .border(1, .gray.opacity(0.5))
                    .padding(.top, 25)
                SecureField("Password", text: $password)
                    .textContentType(.emailAddress)
                    .border(1, .gray.opacity(0.5))
                Button(action: {
                    // 액션 내용
                }) {
                    Text("Reset Password?")
                        .font(.callout)
                        .fontWeight(.medium)
                }
                .tint(.black)
                .hAlign(.trailing)
                Button {
                    // test code
                } label: {
                    Text("Sign in")
                        .foregroundColor(.white)
                        .hAlign(.center)
                        .fillView(.black)
                }
                .padding(.top, 10)
            }
            HStack {
                Text("Don't have an account?")
                    .foregroundColor(.gray)
                Button(action: {
                    createAccount.toggle()
                }) {
                    Text("Register Now")
                        .fontWeight(.bold)
                        .foregroundColor(.black)
                }
            }
            .font(.callout)
            .vAlign(.bottom)
        }
        .vAlign(.top)
        .padding(15)
        .fullScreenCover(isPresented: $createAccount) {
            RegisterView()
        }
    }
}

struct RegisterView: View {
    @State var email: String = ""
    @State var password: String = ""
    @State var userName: String = ""
    @State var userBio: String = ""
    @State var userBioLink: String = ""
    @State var userProfilePicData: Data?
    
    @Environment(\.dismiss) var dismiss
    @State var showImagePicker: Bool = false
//    @State var photoItem: PhotosPickerItem?
    
    var body: some View {
        VStack(spacing: 10) {
            Text("Let's register\naccount")
                .font(.largeTitle.bold())
                .hAlign(.leading)
            Text("Hello user, have a wonderful journey")
                .font(.title3)
                .hAlign(.leading)
            // For smaller size optimization
//            ViewThatFits {
//                ScrollView(.vertical, showsIndicators: false) {
//                    HelperView()
//                }
//                HelperView()
//            }
            HelperView()
            HStack {
                Text("Already have an account?")
                    .foregroundColor(.gray)
                Button(action: {
                    dismiss()
                }) {
                    Text("Login Now")
                        .fontWeight(.bold)
                        .foregroundColor(.black)
                }
            }
            .font(.callout)
            .vAlign(.bottom)
        }
        .vAlign(.top)
        .padding(15)
//        .photosPicker(isPresented: $showImagePicker, selection: $photoItem)
//        .onChange(of: photoItem) { newValue in
//            if let newValue {
//                Task {
//                    do {
//                        let imageData = try await newValue.loadTr
//                    } catch {
//
//                    }
//                }
//            }
//        }
    }
    
    @ViewBuilder
    func HelperView() -> some View {
        VStack(spacing: 12) {
            ZStack {
                if let userProfilePicData = userProfilePicData, let image = UIImage(data: userProfilePicData) {
                    Image(uiImage: image)
                        .resizable()
                        .aspectRatio(contentMode: .fill)
                } else {
                    Image("NullProfile")
                        .resizable()
                        .aspectRatio(contentMode: .fill)
                }
            }
            .frame(width: 85, height: 85)
            .clipShape(Circle())
            .contentShape(Circle())
            .padding(.top, 25)
            .onTapGesture {
                showImagePicker.toggle()
            }
            TextField("Username", text: $userName)
                .textContentType(.emailAddress)
                .border(1, .gray.opacity(0.5))
            TextField("Email", text: $email)
                .textContentType(.emailAddress)
                .border(1, .gray.opacity(0.5))
            SecureField("Password", text: $password)
                .textContentType(.emailAddress)
                .border(1, .gray.opacity(0.5))
            TextField("About You", text: $userBio)
//                TextField("About You", text: $userBio, axis: .vertical)
                .frame(minHeight: 100, alignment: .top)
                .textContentType(.emailAddress)
                .border(1, .gray.opacity(0.5))
            TextField("Bio Link (Optional)", text: $userBioLink)
                .textContentType(.emailAddress)
                .border(1, .gray.opacity(0.5))
            Button {
                // test code
            } label: {
                Text("Sign up")
                    .foregroundColor(.white)
                    .hAlign(.center)
                    .fillView(.black)
            }
            .padding(.top, 10)
        }
    }
}

struct LoginView_Previews: PreviewProvider {
    static var previews: some View {
        LoginView()
    }
}

extension View {
    func hAlign(_ alignment: Alignment) -> some View {
        self.frame(maxWidth: .infinity, alignment: alignment)
    }
    
    func vAlign(_ alignment: Alignment) -> some View {
        self.frame(maxHeight: .infinity, alignment: alignment)
    }
    
    func border(_ width: CGFloat, _ color: Color) -> some View {
        self.padding(.all, 15)
//        self.padding(.horizontal, 15)
//            .padding(.vertical, 15)
            .background {
                RoundedRectangle(cornerRadius: 5, style: .continuous)
                    .stroke(color, lineWidth: width)
            }
    }
    
    func fillView(_ color: Color) -> some View {
        self.padding(.horizontal, 15)
            .padding(.vertical, 15)
            .background {
                RoundedRectangle(cornerRadius: 5, style: .continuous)
                    .fill(color)
            }
    }
}

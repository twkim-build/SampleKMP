//
//  RootView.swift
//  iosApp
//
//  Created by taewoo kim on 21.04.26.
//

import SwiftUI

struct RootView: View {
    @State private var loginVM: LoginViewModel
    @State private var profileVM: ProfileViewModel
    
    init(container: IOSContainer) {
        _loginVM = State(initialValue: LoginViewModel(store: container.authStore))
        _profileVM = State(initialValue: ProfileViewModel(store: container.userStore))
    }
    
    var body: some View {
        if loginVM.isLoggedIn {
            ProfileView(vm: profileVM) {
                loginVM.logout()
            }
        } else {
            LoginView(vm: loginVM)
        }
    }
}


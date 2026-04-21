//
//  LoginView.swift
//  iosApp
//
//  Created by taewoo kim on 21.04.26.
//

import SwiftUI

struct LoginView: View {
    @State private var vm: LoginViewModel
    
    init(vm: LoginViewModel) {
        _vm = State(initialValue: vm)
    }
    
    var body: some View {
        VStack(spacing: 16) {
            TextField("Email", text: $vm.email)
                .textFieldStyle(.roundedBorder)
            SecureField("Password", text: $vm.password)
                .textFieldStyle(.roundedBorder)
            
            if let error = vm.errorMessage {
                Text(error)
                    .foregroundStyle(.red)
            }
            
            Button("Login") {
                vm.login()
            }
            .buttonStyle(.borderedProminent)
            
            if vm.isLoading {
                ProgressView()
            }
        }
        .padding()
    }
}

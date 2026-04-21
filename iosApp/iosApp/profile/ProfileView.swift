//
//  ProfileView.swift
//  iosApp
//
//  Created by taewoo kim on 21.04.26.
//

import SwiftUI

struct ProfileView: View {
    @State private var vm: ProfileViewModel
    let onLogout: () -> Void
    
    init(vm: ProfileViewModel, onLogout: @escaping () -> Void) {
        _vm = State(initialValue: vm)
        self.onLogout = onLogout
    }
    
    var body: some View {
        VStack(spacing: 16) {
            if vm.isLoading {
                ProgressView()
            } else if let error = vm.errorMessage {
                Text(error)
            } else {
                Text("Name: \(vm.name)" )
                    .font(.headline)
                Text("Email: \(vm.email)")
                    .font(.subheadline)
            }
            
            Button("Load Profile") {
                vm.loadProfile()
            }
            .buttonStyle(.borderedProminent)
            
            Button("Logout") {
                onLogout()
            }
        }
        .padding()
    }
}

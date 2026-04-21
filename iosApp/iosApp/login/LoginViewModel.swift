//
//  LoginViewModel.swift
//  iosApp
//
//  Created by taewoo kim on 21.04.26.
//

import Foundation
import Observation
import Shared

@MainActor
@Observable
final class LoginViewModel {
    var email: String = "demo@example.com"
    var password: String = "1234"
    var isLoading: Bool = false
    var isLoggedIn: Bool = false
    var errorMessage: String?
    
    private let store: AuthStore
    
    init(store: AuthStore) {
        self.store = store
        apply(state: store.currentState())
        
        store.watchState { [weak self] state in
            guard let self else { return }
            Task { @MainActor in
                self.apply(state: state)
            }
        }
    }
    
    func login() {
        store.login(email: email, password: password)
    }
    
    func logout() {
        store.logout()
    }
    
    private func apply(state: AuthUiState) {
        isLoading = state.isLoading
        isLoggedIn = state.isLoggedIn
        errorMessage = state.errorMessage
    }
    
    deinit {
        store.clear()
    }
}


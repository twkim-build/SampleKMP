//
//  UserViewModel.swift
//  iosApp
//
//  Created by taewoo kim on 13.04.26.
//

import Foundation
import Shared

@MainActor
@Observable
final class UserViewModel {
    var isLoading = false
    var name = ""
    var email = ""
    var errorMessage: String?
    
    private let store: UserStore
    
    init(store: UserStore) {
        self.store = store
        
        apply(state: store.currentState())

        store.watchState { [weak self] state in
            guard let self else { return }
            Task { @MainActor in
                self.apply(state: state)
            }
        }
    }
    
    func loadUser() {
        store.loadUser(userId: "123")
    }
    
    private func apply(state: UserUiState) {
        isLoading = state.isLoading
        name = state.name
        email = state.email
        errorMessage = state.errorMessage
    }
    
    deinit {
        store.clear()
    }
}

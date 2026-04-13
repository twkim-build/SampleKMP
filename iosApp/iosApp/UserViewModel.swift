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
    var name = ""
    var email = ""
    var loading = false
    var errorMessage: String?
    
    private let presenter: UserPresenter
    
    init(presenter: UserPresenter) {
        self.presenter = presenter
    }
    
    func load() {
        loading = true
        errorMessage = nil
        
        presenter.loadUser(
            onSuccess: { user in
                self.loading = false
                self.name = user.name
                self.email = user.email
            },
            onError: { error in
                self.errorMessage = error
            }
        )
    }
    
    deinit {
    }
}

//
//  IOSContainer.swift
//  iosApp
//
//  Created by taewoo kim on 13.04.26.
//

import Foundation
import Shared

final class IOSContainer {
    private let appContainer: AppContainer
    
    init() {
        #if DEBUG
        let environment = AppEnvironment.dev
        #else
        let environment = AppEnvironment.prod
        #endif
        
        self.appContainer = AppContainer(environment: environment)
    }
    
    lazy var authStore: AuthStore = {
        appContainer.createAuthStore()
    }()
    
    lazy var userStore: UserStore = {
        appContainer.createUserStore()
    }()
}

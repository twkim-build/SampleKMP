//
//  IOSContainer.swift
//  iosApp
//
//  Created by taewoo kim on 13.04.26.
//

import Foundation
import Shared

final class IOSContainer {
    private let container = AppContainer()
    lazy var presenter = container.createPresenter()
}

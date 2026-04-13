import SwiftUI

@main
struct iOSApp: App {
    private let container = IOSContainer()
    
    var body: some Scene {
        WindowGroup {
            ContentView(
                vm: UserViewModel(presenter: container.presenter)
            )
        }
    }
}

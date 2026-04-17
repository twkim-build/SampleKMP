import SwiftUI
import Shared

struct ContentView: View {
    @State private var vm: UserViewModel
    
    init(vm: UserViewModel) {
        _vm = State(initialValue: vm)
    }
    
    var body: some View {
        VStack(spacing: 16) {
            if vm.isLoading {
                ProgressView()
            } else if let errorMessage = vm.errorMessage {
                Text("Error: \(errorMessage)")
            } else {
                Text("Name: \(vm.name)")
                    .font(.headline)

                Text("Email: \(vm.email)")
                    .font(.subheadline)
            }

            Button("Load User") {
                vm.loadUser()
            }
            .buttonStyle(.borderedProminent)
        }
        .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
    }
}

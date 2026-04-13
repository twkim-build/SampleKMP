import SwiftUI
import Shared

struct ContentView: View {
    @State private var vm: UserViewModel
    
    init(vm: UserViewModel) {
        _vm = State(initialValue: vm)
    }
    
    var body: some View {
        VStack(spacing: 16) {
            if vm.loading {
                ProgressView()
            } else if let errorMessage = vm.errorMessage {
                Text("Error: \(errorMessage)")
            } else {
                Text(vm.name)
                    .font(.headline)

                Text(vm.email)
                    .font(.subheadline)
            }

            Button("Load User") {
                vm.load()
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

import SwiftUI
import Shared

struct ContentView: View {
    @State private var showContent = false
    @State private var serverGreeting: String?
    private let greeting = Greeting()
    
    var body: some View {
        VStack {
            Button("Click me!") {
                withAnimation {
                    showContent = !showContent
                    Task {
                        do {
                            serverGreeting = try await greeting.greetFromServer()
                        } catch {
                            serverGreeting = "Error: \(error.localizedDescription)"
                        }
                    }
                }
            }

            if showContent {
                VStack(spacing: 16) {
                    Image(systemName: "swift")
                        .font(.system(size: 200))
                        .foregroundColor(.accentColor)
                    Text("SwiftUI: \(greeting.greet())")
                    if let serverMessage = serverGreeting {
                        Text("Server says: \(serverMessage)")
                    }
                }
                .transition(.move(edge: .top).combined(with: .opacity))
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .top)
        .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

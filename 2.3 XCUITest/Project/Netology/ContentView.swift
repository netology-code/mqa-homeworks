//
//  Created by Netology.
//

import SwiftUI

struct MasterView: View {

    @State private var login: String = ""
    @State private var password: String = ""
    @State private var isDetailsOpened: Bool = false

    var body: some View {
        NavigationView {
            VStack {
                NavigationLink(destination: DetailsView(login: login), isActive: $isDetailsOpened) { EmptyView() }
                TextField("Login", text: $login)
                    .textFieldStyle(.roundedBorder)
                    .accessibilityLabel(Text("login"))
                TextField("Password", text: $password)
                    .textFieldStyle(.roundedBorder)
                    .accessibilityLabel(Text("password"))
                Button("Login") {
                    isDetailsOpened = true
                }
                    .disabled(login.isEmpty || password.isEmpty)
                    .accessibilityLabel(Text("login"))
            }
            .padding()
            .navigationTitle("Login")
        }
    }
}

struct DetailsView: View {

    let login: String

    var body: some View {
        Text(login)
            .navigationTitle("Profile")
            .accessibilityLabel(Text("user_login"))
    }
}

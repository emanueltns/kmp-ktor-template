# Kotlin Multiplatform Template with Ktor

A modern, full-stack Kotlin Multiplatform project template that demonstrates the integration of Ktor server with multiplatform mobile applications. This template provides a foundation for building cross-platform applications with shared business logic.

## 🚀 Features

- **Kotlin Multiplatform Mobile**: Shared code between Android and iOS
- **Ktor Server Integration**: Robust backend implementation with Netty engine
- **Compose Multiplatform**: Modern UI framework for Android
- **SwiftUI Integration**: Native iOS UI implementation
- **SQLDelight**: Type-safe SQL database with multiplatform support
- **Koin**: Lightweight dependency injection
- **Shared Network Layer**: Common networking code across platforms
- **Gradle Version Catalogs**: Centralized dependency management

## 📁 Project Structure

```
kotlin-multiplatform-template/
├── composeApp/           # Compose Multiplatform application
│   └── src/
│       ├── androidMain/  # Android-specific implementations
│       ├── commonMain/   # Shared Compose UI code
│       └── desktopMain/  # Desktop-specific implementations
├── iosApp/              # iOS application (SwiftUI)
├── server/              # Ktor server application
│   └── src/
│       └── main/        # Server implementation
├── shared/              # Shared code between all targets
│   └── src/
│       ├── commonMain/  # Common Kotlin code
│       ├── androidMain/ # Android-specific code
│       └── iosMain/     # iOS-specific code
└── gradle/              # Gradle configuration and dependencies
```

## 🛠 Prerequisites

- JDK 17 or higher
- Android Studio Hedgehog | 2023.1.1 or newer
- Xcode 15+ (for iOS development)
- Kotlin Multiplatform Mobile plugin
- Docker (optional, for containerization)

## 🚦 Getting Started

1. **Clone the Repository**
   ```bash
   git clone <your-repository-url>
   cd kmp-ktor-template
   ```

2. **Setup Environment**
   - Copy `env.properties.template` to `env.properties`
   - Configure your environment-specific settings

3. **Build the Project**
   ```bash
   ./gradlew build
   ```

4. **Run the Server**
   ```bash
   ./gradlew :server:run
   ```
   The server will start at `http://localhost:8080`

5. **Run iOS App**
   - Open `iosApp/iosApp.xcworkspace` in Xcode
   - Select your target device
   - Click Run

6. **Run Android App**
   ```bash
   ./gradlew :composeApp:installDebug
   ```

## 🔧 Configuration

Key configuration files:
- `gradle/libs.versions.toml`: Central dependency management
- `env.properties`: Environment-specific configuration
- `shared/build.gradle.kts`: Shared module configuration
- `server/build.gradle.kts`: Ktor server configuration

## 📦 Key Dependencies

- **Server**:
  - Ktor: Web framework
  - Logback: Logging
  - Netty: Server engine
  - Koin: Dependency injection

- **Shared**:
  - Kotlin Coroutines: Asynchronous programming
  - Ktor Client: HTTP client
  - Kotlinx Serialization: JSON serialization
  - SQLDelight: SQL database
  - Koin Core: Dependency injection
  - Kotlinx DateTime: Date/time utilities

- **Android**:
  - Compose Multiplatform: UI framework
  - Android KTX: Kotlin extensions
  - SQLDelight Android: Native database driver

- **iOS**:
  - SwiftUI: UI framework
  - SQLDelight Native: Native database driver

## 🗄️ Database Setup

The project uses SQLDelight for type-safe database access:
- Generates Kotlin APIs from SQL statements
- Supports multiplatform with native drivers
- Provides coroutines extensions for async operations
- Includes migration support

## 💉 Dependency Injection

Koin is used for dependency injection across the project:
- Lightweight and pragmatic DI framework
- Native Kotlin DSL
- Multiplatform support
- Scope and parameter support
- Easy integration with Ktor

## 🤝 Contributing

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📚 Learn More

- [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html)
- [Ktor Documentation](https://ktor.io/)
- [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/)
- [SwiftUI](https://developer.apple.com/xcode/swiftui/)
- [SQLDelight](https://cashapp.github.io/sqldelight/)
- [Koin](https://insert-koin.io/)

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
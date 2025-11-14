# CA Compte - Credit Agricole Banking Application

An Android banking application that allows users to view and manage their bank accounts, transactions, and perform financial simulations. The app supports both Credit Agricole accounts and other banking institutions.

## Screenshots

<table>
  <tr>
    <td><img src="Screenshot_20230306_142741.png" width="250"/></td>
    <td><img src="Screenshot_20230306_142814.png" width="250"/></td>
    <td><img src="Screenshot_20230306_142830.png" width="250"/></td>
  </tr>
</table>

## Features

- **Multi-Bank Account Management**: View accounts from Credit Agricole and other banking institutions
- **Account Overview**: Display account balances, holders, and contract details
- **Transaction History**: Browse detailed operation/transaction history for each account
- **Financial Simulations**: Perform banking simulations and calculations
- **Network Status Handling**: Automatic detection of network connectivity
- **Remote & Local Data**: Support for both remote server data and local data fallback
- **Expandable Bank Lists**: Interactive UI with expandable bank account sections
- **Real-time Updates**: Live data updates using coroutines and LiveData

## Tech Stack

### Language
- **Kotlin** - 100% Kotlin codebase

### Architecture
- **MVVM (Model-View-ViewModel)** - Clean architecture pattern
- **Repository Pattern** - Data abstraction layer
- **Use Cases** - Business logic separation

### Android Components
- **Navigation Component** - Single Activity architecture with multiple fragments
- **ViewBinding** - Type-safe view access
- **LiveData** - Observable data holder
- **ViewModel** - Lifecycle-aware data management
- **Fragments** - Modular UI components

### Dependency Injection
- **Dagger Hilt** - Dependency injection framework

### Networking
- **Retrofit** - REST API client
- **OkHttp** - HTTP client with logging interceptor
- **Moshi** - JSON serialization/deserialization
- **Gson** - Alternative JSON parser

### Asynchronous Programming
- **Kotlin Coroutines** - Asynchronous operations
- **Flow** - Reactive streams

### UI Components
- **Material Design Components** - Modern UI/UX
- **RecyclerView** - Efficient list displays with custom adapters
- **ConstraintLayout** - Flexible layout design
- **Bottom Navigation** - Tab-based navigation

## Project Structure

```
com.example.ca_compte
├── adapters/
│   ├── AccountAdapter.kt       # RecyclerView adapter for accounts
│   ├── BankAdapter.kt          # RecyclerView adapter for banks
│   └── OperationAdapter.kt     # RecyclerView adapter for transactions
├── data/
│   ├── model/
│   │   ├── Account.kt          # Account data model
│   │   ├── Bank.kt             # Bank data model
│   │   ├── BankItem.kt         # UI bank item wrapper
│   │   ├── Operation.kt        # Transaction data model
│   │   └── UserData.kt         # User data model
│   └── BankAPI.kt              # Retrofit API interface
├── di/
│   └── AppModule.kt            # Hilt dependency injection module
├── presentation/
│   ├── AccountFragment.kt      # Main accounts screen
│   ├── AccountViewModel.kt     # Accounts screen ViewModel
│   ├── OperationFragment.kt    # Transaction details screen
│   ├── SimulationFragment.kt   # Financial simulation screen
│   ├── UserFragment.kt         # User interaction screen
│   └── UserClickListener.kt    # Click event handler interface
├── repository/
│   ├── BankRepository.kt       # Repository interface
│   └── BankRepositoryImpl.kt   # Repository implementation
├── useCase/
│   └── BankUseCase.kt          # Business logic layer
├── utils/
│   ├── Constants.kt            # App-wide constants
│   ├── NetworkUtil.kt          # Network connectivity utilities
│   └── Resource.kt             # Generic API response wrapper
├── BankApplication.kt          # Application class
└── MainActivity.kt             # Single Activity host
```

## Prerequisites

- **Android Studio**: Arctic Fox (2020.3.1) or higher
- **Android SDK**: API 24 (Android 7.0) or higher
- **Target SDK**: API 33 (Android 13)
- **Kotlin**: 1.8.0 or higher
- **Gradle**: 7.0 or higher

## Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/compte.git
   cd compte
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing project"
   - Navigate to the cloned directory and select it

3. **Sync Gradle**
   - Android Studio will automatically sync Gradle dependencies
   - If not, click "Sync Project with Gradle Files" in the toolbar

4. **Build the project**
   ```bash
   ./gradlew build
   ```

5. **Run the application**
   - Connect an Android device or start an emulator
   - Click "Run" in Android Studio or use:
   ```bash
   ./gradlew installDebug
   ```

## Configuration

### API Endpoint

The application fetches bank data from a remote server. Configure the base URL in the `Constants.kt` or `AppModule.kt` file:

```kotlin
private const val BASE_URL = "https://your-api-endpoint.com/"
```

### Network Configuration

The app automatically handles network connectivity:
- **Remote Mode**: Fetches data from the API when internet is available
- **Local Mode**: Falls back to local data when offline (if implemented)

### Data Sources

According to the current implementation:
- **Option 1**: Obtain banking data remotely from API
- **Option 2**: Obtain banking data locally (fallback mechanism)

## Usage

### Main Screens

1. **Accounts Screen** (`AccountFragment`)
   - View all bank accounts grouped by institution
   - Expandable sections for Credit Agricole and other banks
   - Tap an account to view detailed operations

2. **Operations Screen** (`OperationFragment`)
   - Display transaction history for selected account
   - Shows amount, date, category, and description
   - Scrollable list of all transactions

3. **Simulation Screen** (`SimulationFragment`)
   - Perform financial calculations and simulations
   - Interactive tools for banking scenarios

4. **User Screen** (`UserFragment`)
   - User-interactive features and settings
   - Personalized banking experience

### Navigation

The app uses bottom navigation with three main tabs:
- **Mes Comptes** (My Accounts)
- **Simulation** (Financial Simulations)
- **A vous de jouer** (Your Turn/Interactive)

## Dependencies

### Core Dependencies
```gradle
// Android Core
androidx.core:core-ktx:1.7.0
androidx.appcompat:appcompat:1.6.1
com.google.android.material:material:1.8.0

// Navigation
androidx.navigation:navigation-fragment-ktx:2.5.3
androidx.navigation:navigation-ui-ktx:2.5.3

// Lifecycle
androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1
androidx.lifecycle:lifecycle-livedata-ktx:2.5.1
androidx.lifecycle:lifecycle-runtime-ktx:2.5.1

// Networking
com.squareup.retrofit2:retrofit:2.9.0
com.squareup.retrofit2:converter-gson:2.9.0
com.squareup.okhttp3:okhttp:5.0.0-alpha.2
com.squareup.okhttp3:logging-interceptor:4.10.0

// JSON Parsing
com.squareup.moshi:moshi:1.13.0

// Coroutines
org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4
org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4

// Dependency Injection
com.google.dagger:hilt-android:2.44.2
```

## Architecture Overview

### MVVM Pattern

```
View (Fragment) → ViewModel → UseCase → Repository → API/Local Data
                     ↓
                  LiveData
                     ↓
                 UI Update
```

### Data Flow

1. **UI Layer**: Fragments observe LiveData from ViewModels
2. **ViewModel Layer**: Manages UI state and business logic orchestration
3. **Use Case Layer**: Encapsulates business logic
4. **Repository Layer**: Single source of truth for data
5. **Data Sources**: Remote API and local fallback

### Error Handling

The app uses a `Resource` wrapper class to handle different states:
- `Resource.Loading()` - Data is being fetched
- `Resource.Success(data)` - Data fetched successfully
- `Resource.Error(message)` - Error occurred with message

Common error scenarios:
- No internet connection
- Network timeout
- API key limitations
- File not found (404)
- Conversion errors

## Known Issues

- **Web service link does not work** (404 error with okhttp)
  - The remote API endpoint may be unavailable
  - Consider implementing local data as fallback

## Testing

Run unit tests:
```bash
./gradlew test
```

Run instrumentation tests:
```bash
./gradlew connectedAndroidTest
```

## Building for Production

Generate a release APK:
```bash
./gradlew assembleRelease
```

The APK will be located at:
```
app/build/outputs/apk/release/app-release.apk
```

## Code Style

This project follows the [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html).

## Version History

- **1.0** (Current)
  - Initial release
  - Multi-bank account management
  - Transaction history viewing
  - Financial simulation tools
  - Remote data fetching with local fallback

## Future Enhancements

- [ ] Implement local database for offline support
- [ ] Add authentication and security features
- [ ] Implement push notifications for account updates
- [ ] Add biometric authentication
- [ ] Support for multiple languages (i18n)
- [ ] Dark mode support
- [ ] Account transfer functionality
- [ ] Budget tracking and analytics
- [ ] Export transactions to PDF/CSV

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is available for educational and demonstration purposes.

## Contact

For questions or support, please open an issue in the repository.

---

**Note**: This application is designed for demonstration purposes. Ensure proper security measures are implemented before using with real banking data.

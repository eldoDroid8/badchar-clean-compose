# BadChar-Clean-Compose

A showcase Android project demonstrating the use of **Clean Architecture** and **Jetpack Compose** to build a modern, scalable, and testable application. The app fetches characters from the *Breaking Bad* series and displays them in a list. Selecting a character from the list shows detailed information about the character.

---

## Features
- **Breaking Bad Characters**: Fetches a list of characters from the *Breaking Bad* series using an API.
- **Character Details**: Displays detailed information when a character is selected.
- **Jetpack Compose**: Entire UI is built using Jetpack Compose for a modern declarative UI approach.
- **Clean Architecture**: Separation of concerns with clearly defined layers (Domain, Data, and Presentation).
- **Coroutines and Flow**: Utilized for asynchronous and reactive programming.
- **Dependency Injection**: Powered by [Hilt](https://developer.android.com/training/dependency-injection/hilt).
- **Kotlin Best Practices**: Follows modern Kotlin coding standards.

---

## Project Architecture

This project follows **Clean Architecture** principles with the following layers:
1. **Domain**:
   - Contains business logic and use cases.
   - Abstract definitions of repositories.
2. **Data**:
   - Responsible for data handling and API interactions.
   - Contains implementations of repositories using Retrofit.
3. **Presentation**:
   - Manages UI using Jetpack Compose.
   - ViewModels for state management.

---

## Tech Stack
- **Language**: Kotlin
- **UI**: Jetpack Compose
- **Architecture**: Clean Architecture
- **Networking**: Retrofit, OkHttp
- **Dependency Injection**: Hilt
- **Async**: Kotlin Coroutines
- **Testing**: JUnit, Mockk

---

## Screenshots
*Add screenshots of the app here*

---

## Getting Started

### Prerequisites
- Android Studio Giraffe or higher
- Minimum SDK: 21
- Target SDK: 33
- Kotlin 1.9.0 or above

### Installation
1. Clone this repository:
   ```bash
   git clone https://github.com/yourusername/badchar-clean-compose.git

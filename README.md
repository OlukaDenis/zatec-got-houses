# G O T Houses

This application fetches Game of Thrones houses from and external [Game of Thrones API](https://anapioficeandfire.com/) and displays them to the user.

### Screenshots


<table>
 <tr>
   <th>Home </th>
   <th>House Details </th>
 </tr>
 <tr>
  <td><img src="https://user-images.githubusercontent.com/37341054/203771561-e54462b5-0e67-4fd5-82f2-44654061cd44.jpg" /> </td>
  <td><img src="https://user-images.githubusercontent.com/37341054/203771590-11f7306c-0bb7-4752-89d1-ffc965099e35.jpg" /> </td>
 </tr>
</table>


## Project Structure

### Data module
Contains the data logic from local source or remote API.
Implements domain and network interfaces including retrofit services and api client.

### Domain module
Contains the business logic. Converts, filters, mix and sorts raw data that comes from Data layer
to be ready and easy to handle in Presentation layer.

### App mudule
Contains UI components and the logic that related to user interactions or navigation.

## Installation

Clone this repository and import it into your Android studio

```
git clone git@github.com:OlukaDenis/zatec-got-houses.git
```

## Tools

- Kotlin
- Java Development Kit (JDK) 11
- Android Studio Bumblebee version and above
- Android SDK
- AGP 7

## Code quality

### Run lint

```
./gradlew lint
```

### Run tests

Run module specific unit tests
Data module: `./gradlew :data:testDebugUnitTest`

Domain module: `./gradlew :domain:testDebugUnitTest`

App module: `./gradlew :app:testDebugUnitTest`

Run all tests
```
./gradlew test
```

The command below runs tests and generates test coverage

```
./gradlew jacocoAndroidTestReport
```

### Test report

 - For combined coverage: `./gradlew :rootCoverageReport`
 - For module specific coverage (all modules): `./gradlew coverageReport`
 - For module specific coverage (single module):
   Data module:  `./gradlew :data:coverageReport`
   Domain module:  `./gradlew :domain:coverageReport`
   App module:  `./gradlew :app:coverageReport`

Get the test report from `/<root-project-directory>/build/reports/jacoco/index.html` and then run it in your preferred browser

### Tes coverage
<img width="1680" alt="Screenshot 2022-11-24 at 13 24 35" src="https://user-images.githubusercontent.com/37341054/203770606-09cfe78b-0908-41d2-a4b3-9449c40657cc.png">


## Contributing code

### Language

The codebase is entirely Kotlin and all files must be written in Kotlin

### Architecture

The project use MVVM architecture

Kudos!

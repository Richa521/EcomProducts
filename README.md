# EcomProducts App

This Android app showcases various products retrieved from the endpoint [https://dummyjson.com/products](https://dummyjson.com/products). Users can view a list of products, click on any product to see its details on a separate screen, and utilize swipe-to-refresh functionality to fetch the latest products. The app also auto-refreshes products every 3 minutes, and there's a dedicated UI to show the last refresh time.

## Functional Requirements

1. **List of Products:**
   - Displays each product as a list item, picking appropriate fields from the response.
   - Clicking on any product shows a separate screen with the full product details.

2. **Refresh Functionality:**
   - Implements swipe-to-refresh to fetch the latest products.
   - Auto-refreshes products every 3 minutes.
   - Dedicated UI to show the last refresh time.

3. **Tests:**
   - Includes unit and instrumentation tests.

## Technologies Used

- **Language:** Kotlin
- **Networking:** Retrofit
- **Image Loading:** Coil
- **UI:** Jetpack Compose
- **Testing:** JUnit, Espresso

## 3rd Party Dependencies

- [Retrofit](https://square.github.io/retrofit/): For making network requests.
- [Coil](https://coil-kt.github.io/coil/): For loading and caching images.

## Architecture

The app follows the MVVM (Model-View-ViewModel) architecture pattern:

- **Model:** Represents the data and business logic, including the repository and data access objects.
- **View:** Displays the UI and interacts with the user.
- **ViewModel:** Acts as a bridge between the Model and the View, handling UI-related logic.


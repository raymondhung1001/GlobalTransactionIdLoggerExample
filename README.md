# GlobalTransactionIdLoggerExample

This repository demonstrates how to implement global transaction ID logging in a typical application. The main objective is to provide an example of how to generate, propagate, and log a unique transaction identifier across various layers of an application, which can be essential for distributed tracing, debugging, and monitoring.

## Features

- **Global Transaction ID generation**  
  Generates a unique ID for each transaction/request entering the system.

- **Propagation across layers**  
  Ensures that the transaction ID is passed through different services and components.

- **Logging integration**  
  Logs the transaction ID with each log statement, making it easy to correlate logs.

## Technologies Used

- Java
- JSF
- Log4j2 for logging

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven

### Build and Run

1. **Clone the repository**

    ```bash
    git clone https://github.com/raymondhung1001/GlobalTransactionIdLoggerExample.git
    cd GlobalTransactionIdLoggerExample
    ```

2. **Build the project**

    ```bash
    mvn clean package
    ```

3. **Run the application**

    ```bash
    mvn tomee:run
    ```

## License

This project is licensed under the Apache 2.0 License. See the [LICENSE](LICENSE) file for details.

## Contact

For questions or support, contact [raymondhung1001](https://github.com/raymondhung1001).

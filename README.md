# BTC Balance Checker

BTC Balance Checker is a web application that allows users to check the balance of their Bitcoin wallet addresses. The application retrieves the balance of the Bitcoin wallet address by querying the blockchain using a third-party API.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

The following software is required to be installed on your system:

- Java 8 or higher
- Maven
- Git

### Installing

Clone the repository using Git:

```shell
git clone https://github.com/freelkee/BTC-Balance-Checker.git
```

Navigate to the project directory and build the project using Maven:

```shell
cd BTC-Balance-Checker
mvn clean install
```

Run the application using Maven:

```shell
mvn spring-boot:run
```

The application should now be running on `http://localhost:8080`.

## Usage

To check the balance of a Bitcoin wallet address, enter the wallet address in the input field and click the "Check Balance" button. The application will retrieve the balance of the wallet address and display it on the page.

## Built With

- Spring Boot - The web framework used
- Thymeleaf - The template engine used
- Maven - Dependency management

## Contributing

Contributions are welcome. Please submit a pull request with your changes.

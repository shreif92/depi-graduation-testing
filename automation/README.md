# Test Automation Framework

This repository contains an automated testing framework built with Java, Selenium WebDriver, TestNG, and Allure reporting.

## 🛠 Technology Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Allure Report
- XML Configuration

## 📁 Project Structure

```
├── src/
│   ├── main/         # Main source code
│   └── test/         # Test source code
├── screenshots/      # Test execution screenshots
├── allure-results/  # Allure report data
├── pom.xml          # Maven dependencies and build configuration
└── Runner.xml       # TestNG suite configuration
```

## 🚀 Getting Started

### Prerequisites

- Java JDK 8 or higher
- Maven
- Chrome/Firefox browser
- Allure command-line tool (for viewing reports)

### Installation

1. Clone the repository:

```bash
git clone https://github.com/shreif92/depi-graduation-testing
```

2. Install dependencies:

```bash
mvn clean install
```

## 🏃‍♂️ Running Tests

### Run all tests:

```bash
mvn clean test
```

### Run specific test suite:

```bash
mvn clean test -DsuiteXmlFile=Runner.xml
```

## 📊 Reports

### Generate Allure Report

After test execution, generate the report using:

```bash
allure serve allure-results
```

## 📝 Configuration

- Configure test parameters in `Runner.xml`
- Update browser configurations in test configuration files
- Modify test data as needed

## 🔍 Key Features

- Page Object Model design pattern
- TestNG test framework
- Allure reporting with screenshots
- Maven for dependency management
- Parallel test execution support
- Screenshot capture on test failure

## 📫 Contact

For any questions or concerns, please open an issue in the repository.

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

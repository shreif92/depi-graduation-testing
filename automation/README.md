# QaFox Test Automation Framework

A robust test automation framework for web application testing, specifically designed for the Tutorial Ninja demo e-commerce website. This project uses Selenium WebDriver with Java, TestNG, and Allure reporting.

## 🚀 Features

- Cross-browser testing support (Chrome, Firefox, Edge)
- Page Object Model (POM) design pattern
- Data-driven testing capabilities
- Allure reporting integration
- Screenshot capture on test failure
- Parallel test execution support
- Configurable test parameters

## 🛠 Tech Stack

- Java 23
- Selenium WebDriver 4.28.1
- TestNG 7.10.2
- Cucumber 7.20.1
- Allure TestNG 2.21.0
- JavaFaker 1.0.2
- Maven

## 📋 Prerequisites

- Java JDK 23 or higher
- Maven 3.x
- Chrome/Firefox/Edge browser
- Allure command-line tool (for viewing reports)

## 🔧 Setup

1. Clone the repository:

```bash
git clone "https://github.com/shreif92/depi-graduation-testing"
```

2. Install dependencies:

```bash
mvn clean install
```

3. Set up WebDriver (the project uses Selenium Manager, so no manual driver setup is required)

## 🏃‍♂️ Running Tests

### Run all tests:

```bash
mvn test
```

### Run tests with specific browser:

```bash
mvn test -Dbrowser=chrome
mvn test -Dbrowser=firefox
mvn test -Dbrowser=edge
```

### Generate and view Allure report:

```bash
mvn allure:serve
```

## 📁 Project Structure

```
├── src
│   ├── main
│   │   └── java
│   └── test
│       └── java
│           ├── Base
│           │   └── TestBase.java
│           ├── Pages
│           │   ├── HomePage.java
│           │   ├── LoginPage.java
│           │   ├── RegisterPage.java
│           │   └── ...
│           ├── Tests
│           │   ├── LoginTest.java
│           │   ├── RegisterTest.java
│           │   └── ...
│           └── Utils
├── allure-results/
├── screenshots/
├── pom.xml
└── README.md
```

## 📝 Test Cases

The framework includes automated tests for:

- User Registration
- Login/Logout
- Password Change
- Product Search and Navigation
- Shopping Cart Operations
- Checkout Process

## 📊 Reporting

The framework uses Allure for reporting, which provides:

- Detailed test execution reports
- Test step visualization
- Screenshots of failures
- Test execution timeline
- Various statistics and charts

## 🤝 Contributing

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details

## 🙏 Acknowledgments

- [Tutorial Ninja](https://tutorialsninja.com/demo/) for providing the demo site
- Selenium WebDriver community
- TestNG framework contributors
- Allure reporting team

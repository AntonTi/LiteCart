# LiteCart Web application UI Automation Tests (Java)

## REQUIREMENTS:
- JDK (1.8 or higher);
- apache maven (3.6.3 or higher);
- ChromeDriver (latest version);
- Allure (for test report);
- Jenkins (for CI/CD);
- IntelliJ IDEA (IDE).

## INSTALLATION:
- download ChromeDriver (latest stable release):
<https://chromedriver.chromium.org>

- add the folder where the ChromeDriver is located to system variables

- **MAKE SURE** you have the latest version of Chrome browser installed

## RUN:
On command line, type in the following command:
`mvn clean test`

## ALLURE REPORT:
On command line, type in the following command:
`allure serve allure-results`
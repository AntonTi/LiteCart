# LiteCart Web application UI Automation Tests (Java)

## REQUIREMENTS:
- LiteCart - Application under test (1.3.6);
- XAMPP (3.3.0);
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

## CONFIGURATION:
**IMPORTANT!** XAMPP configuration:
- Before running tests delete files **.htpasswd** and **.htaccess** that are in the folder
  `\\xampp\htdocs\litecart\admin\`

**IMPORTANT!** Project configuration:
- In project folder `\\LiteCart\src\test\resources\` 
change the lines in the file **config.properties** to your admin username and password:
    - line #3 (adminUsername)
    - line #4 (adminPassword)

## RUN:
On command line, type in the following command:
`mvn clean test`

## ALLURE REPORT:
On command line, type in the following command:
`allure serve allure-results`
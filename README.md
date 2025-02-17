## **Introduction**:
This framework is designed to automate "Akakce" app testing using Appium, Java, and Cucumber. 
It leverages the Behavior-Driven Development (BDD) approach, enabling easy collaboration between technical and non-technical stakeholders through feature files written in the Gherkin language.

## **Features**:
**Platform Support**: Configurable for both Android and iOS devices.

**BDD with Cucumber**: Write readable and maintainable test scenarios.

**Modular Architecture**: Organized with Page Object Model (POM) for reusable and scalable test design.

**Driver Management**: Dynamically decide and initialize platform-specific drivers.

**Configurable Properties**: Centralized configuration management using config.properties.

**Pre- and Post-Execution Hooks**: Configure actions before and after tests.


## **Pre-requisites**:
Ensure you have the following installed: Java 22.

Maven 3.x or higher.

Appium Server installed and running.

Mobile device or emulator configured and connected.

## **Installation**:

1. Clone the Repository with this command.
   ```git clone https://github.com/iMayth/AkakceMobileTests.git```
  
2. Install Dependencies.
   Use Maven to install the necessary dependencies: ```mvn clean install```.
   
3. Configure Appium.
Download and install Appium.

4. Set Up Device or Emulator.
Connect a real device or start an emulator.
Update config.properties with your device settings.

## **Project Structure**:
![image](https://github.com/user-attachments/assets/a1cfab41-6167-489a-b3f3-faa5910d447d)



## **Key Components**
## *1.Pages*
**BasePage**: Contains reusable Appium driver methods like element interactions, scrolling, and waits.

**MainPage**:
Extend BasePage.
Contain locators and page-specific methods to interact with app elements.
Designed to encapsulate actions for their respective feature steps.

## *2.Step Definitions*
**Hooks**: Configures actions before and after execution, such as starting/stopping the Appium driver and cleaning up test data.

**MainStepDefs**: Define Gherkin steps with Java code. Use page classes for implementing test actions.

## *3. Runners*
**Runner**: Configures the test execution with Cucumber options and JUnit annotations.

## *4.Utilities*
**Driver**: Configures and initializes Appium drivers for Android and iOS. Dynamically decides the driver based on properties in config.properties.

**ConfigLoader**: Reads and provides values from config.properties. Centralizes configuration for device, platform, and other settings.

## *5. Features*
Located under src/test/resources/features.
Written in Gherkin syntax to describe test scenarios.

## *Running Tests*
1. **Via Maven**:
Execute all tests: ```mvn clean install```

2. **Run tests by tag**:
```mvn test -Dcucumber.filter.tags="@smokeTestLogin" ```

3. **Via Runner Class**:
Open Runner.java in your IDE. Right-click on the file and select Run 'Runner'.




# Cucumber
| **Advantages**                               | **Disadvantages**                            |
|----------------------------------------------|----------------------------------------------|
| **Improves Collaboration**: Allows stakeholders, developers, and testers to work together using Gherkin syntax, which is easy to read and write in plain English. | **Steep Learning Curve for Non-Technical Users**: Gherkin syntax is user-friendly, but writing effective BDD scenarios and using Cucumber can be challenging for non-technical users. |
| **Enhances Test Coverage**: Encourages defining scenarios for every feature, improving test coverage and ensuring critical paths are covered. | **Increased Setup and Maintenance Time**: Setting up a Cucumber test framework requires initial effort, and maintaining it for large projects can be time-consuming. |
| **Encourages Clarity and Documentation**: Cucumber tests serve as documentation for the application, helping new team members understand the system's behavior. | **Risk of Writing Overly Detailed Scenarios**: Overly specific scenarios can lead to brittle tests that break with small UI changes, making tests harder to manage. |
| **Reduces Ambiguity**: Defining expected behavior upfront minimizes misunderstandings about how a feature should work. | **May Lead to Redundant Tests**: Without careful management, Cucumber tests can become repetitive, increasing test execution time without much added value. |
| **Automates Acceptance Testing**: Supports automation, allowing teams to verify feature completion through automated acceptance tests. | **Complexity in Integrating with Non-Web Applications**: Integrating Cucumber with non-web applications can be complex and may require custom solutions. |

## Cucumber: `Scenario` vs `Scenario Outline`

### Cucumber: Scenario
- A `Scenario` represents a single test case describing a specific behavior of the application.
- Each `Scenario` contains a fixed set of steps and expected outcomes.
- Use `Scenario` when you want to test a single path or outcome without variable data.

**Example:**

```gherkin
Scenario: Login with valid credentials
  Given the user is on the login page
  When the user enters "username" and "password"
  Then the user should be logged in successfully
```
### Cucumber: Scenario Outline
- Use `Scenario Outline` for testing the same behavior under different conditions.
- It is particularly useful for testing the same feature with various input combinations, such as different user credentials or form inputs.

### Example

```gherkin
Scenario Outline: User login with different credentials
  Given the user is on the login page
  When the user enters "<username>" and "<password>"
  Then the user should see "<outcome>"

Examples:
  | username   | password | outcome             |
  | user1      | pass123  | login successful    |
  | invalid    | pass123  | login failed        |
  | user1      | wrongpass| login failed        |
```

**Purpose of glue**
The glue option links the feature file (written in Gherkin) to the code that implements the test logic (step definitions)
```java
@CucumberOptions(
    features = "src/test/resources/features", // Path to feature files
    glue = "com.example.stepdefinitions" // Path to step definition package
)
public class RunCucumberTest {
}
```

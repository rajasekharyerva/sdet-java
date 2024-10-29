# Allure Report
[Allure Doc](https://allurereport.org/)
[Allure TestNG doc](https://allurereport.org/docs/testng/)
##  Commands
| Command Name       | Command                                         |
|--------------------|-------------------------------------------------|
| Install - Mac      | `brew install allure`                           |
| Version            | `allure --version`                              |
| Server View Report | `allure serve <allure-reports-path>`            |
| Generate Report    | `allure generate <allure-reports-path>`         |
| Generate Report    | `allure generate --clean <allure-reports-path>` |
| Exit               | `Ctrl + C`                                      |


### Specifying Allure Results location
    mvn test -Dallure.results.directory=target/allure-resultsmvn -Dtest=SampleTest#fillForm

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.5.1</version>
                <configuration>
                    <systemPropertyVariables>
                        <allure.results.directory>${project.build.directory}/allure-results</allure.results.directory>
                    </systemPropertyVariables>
                </configuration>
            </plugin>
        </plugins>
    </build>

## @Step Alternate Function usage
    io.qameta.allure.Allure.step("Entering last name", () -> methodName();

## AspectJ
    Allure leverages AspectJ for the functionality of @Step and @Attachment annotations.

    <!-- Add the following options to your maven-surefire-plugin -->
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.1.2</version>
        <configuration>
            <argLine>
                -javaagent:"${settings.localRepository}/org/aspectj/aspectjweaver/${aspectj.version}/aspectjweaver-${aspectj.version}.jar"
            </argLine>
        </configuration>
    </plugin>

## Allure Test Name Alternative
    Allure.getLifecycle().updateTestCase(result -> {
            result.setName("TC6-Delete API TEST");
    });
# Allure Report
[Allure Doc](https://allurereport.org/)
##  Commands
| Command Name       | Command                              |
|--------------------|--------------------------------------|
| Server View Report | `allure serve <allure-reports-path>` |
| Exit               | Ctrl + C                             |
| Install - Mac      | brew install allure                  |
| Version            | `allure --version`                   |


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

io.qameta.allure.Allure.step("Entering last name", () -> methodName();

# Allure Report
[Allure Doc](https://allurereport.org/)
##  Commands
| Command Name       | Command                              |
|--------------------|--------------------------------------|
| Server View Report | `allure serve <allure-reports-path>` |
| Exit               | Ctrl + C                             |


mvn test -Dallure.results.directory=target/allure-resultsmvn -Dtest=SampleTest#fillForm


<build>
    <plugins>
        <plugin>
            <groupId>io.qameta.allure</groupId>
            <artifactId>allure-maven</artifactId>
            <version>2.14.0</version>
            <configuration>
                <resultsDirectory>${project.build.directory}/allure-resultsass</resultsDirectory>
            </configuration>
        </plugin>
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

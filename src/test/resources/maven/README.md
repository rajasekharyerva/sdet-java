# Maven
[Maven](https://maven.apache.org/plugins/index.html)
[Maven Repository](https://mvnrepository.com/)
## Build
| Command Name         | Command                                  |
|----------------------|------------------------------------------|
| Groups               | `mvn test -Dgroups=<sanity>`             |
| ClassName#MethodName | `mvn test -Dtest=<ClassName#MethodName>` |
|                      | `mnv test`                               |
| Gatling              | `mvn gatling:test`                       |

# Dependencies
    Selenium
    API
    Gatling
    XML
    Allure
    Extent
    AspectJ


### Skip Tests
```
-DskipTests
-Dmaven.test.skip
mvn clean install -DskipTests

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.0.0-M7</version>
            <configuration>
                <skipTests>true</skipTests>
                <excludes>
                    <exclude>**/MyTestClass.java</exclude>
                    <exclude>**/com/example/*Test.java</exclude>
                </excludes>
            </configuration>
        </plugin>
    </plugins>
</build>


<profiles>
    <profile>
        <id>skip-tests</id>
        <properties>
            <skipTests>true</skipTests>
        </properties>
    </profile>
</profiles>

mvn clean install -Pskip-tests
```


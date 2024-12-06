# Jenkins
| Command Name                   | Command                                              |
|--------------------------------|------------------------------------------------------|
| Jenkins Docker                 | `docker pull jenkins/jenkins:lts-jdk17`              |
|                                | `docker logs -f jenkins`                             |
|                                | `username=rajasekharreddyyerva docker-compose up -d` |
| Restart                        | `docker restart <jenkins_container_name>`            |
| Install the latest LTS version | `brew install jenkins-lts`                           |
| Start the Jenkins service      | `brew services start jenkins-lts`                    |

## Plugins
    Maven Integration
    Allure or HTML Publisher Plugin
    Git

## Tool Configuration
    Java
    Maven

## Install plugins/tools
    remove plugins - cd /var/jenkins_home/plugins
    rm -f maven-plugin.hpi maven-plugin.jpi


    Update package list
    apt-get update
    apt-get install -y maven

## macOS Installers for Jenkins LTS
| Command Name                    | Command                             |
|---------------------------------|-------------------------------------|
| Install the latest LTS version: | `brew install jenkins-lts`          |
| Start the Jenkins service:      | `brew services start jenkins-lts`   |
| Restart the Jenkins service:    | `brew services restart jenkins-lts` |
| Update the Jenkins version:     | `brew upgrade jenkins-lts`          |
| Stop the Jenkins service        | `brew services stop jenkins-lts`    |

## Triggers
[CRON](https://crontab.cronhub.io/)
```    H/5 * * * * - Every 5 minutes
    - Minutes(0-59)
    - Hours(0-23)
    - Day of Month(1-31)
    - Month(1-12)
    - Month(0-7)
    *: Any value (every possible value in that field).
    /: Step values (e.g., */15 for every 15 minutes).
    ,: Multiple values (e.g., 1,15,30 for minute field).
    -: Range of values (e.g., 9-17 for hours from 9 AM to 5 PM)
```
## Jenkins Job
    - Free Style/Pipeline
    - SCM
    - Trigger
    - Build
    - Post Build
    - Run

### Steps to Pass Method Name in Jenkins Job and Run Specific Test
    Create a Parameterized Jenkins Job
        create a new job or configure an existing job.
        In the job configuration, check the "This project is parameterized" checkbox.
    Add a String Parameter for Test Method
        Add a String Parameter in the parameters section with a name like TEST_METHOD.
        The default value could be a sample test method name, e.g., TestClassName#testMethod.
    Use the Parameter in Maven Command
        mvn clean test -Dtest=${TEST_METHOD}


     




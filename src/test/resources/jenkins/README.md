# Jenkins
| Command Name                   | Command                                             |
|--------------------------------|-----------------------------------------------------|
| Jenkins Docker                 | `docker pull jenkins/jenkins:lts-jdk17`             |
|                                | `docker logs -f jenkins`                            |
|                                | `username=rajasekharreddyerva docker-compose up -d` |
| Restart                        | `docker restart <jenkins_container_name>`           |
| Install the latest LTS version | `brew install jenkins-lts`                          |
 | Start the Jenkins service      | `brew services start jenkins-lts`                   |

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
    H/5 * * * * - Every 5 minutes
    - Minutes
    - Hours
    - Day
    - Week
    - Month

## Jenkins Job
    - Free Style/Pipeline
    - SCM
    - Trigger
    - Build
    - Post Build
    - Run



## Show hidden folders in mac cmd
    cp -R /path/to/source/folder/ /path/to/destination/


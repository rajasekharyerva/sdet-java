# Jenkins
| Command Name   | Command                                             |
|----------------|-----------------------------------------------------|
| Jenkins Docker | `docker pull jenkins/jenkins:lts-jdk17`             |
|                | `docker logs -f jenkins`                            |
|                | `username=rajasekharreddyerva docker-compose up -d` |

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

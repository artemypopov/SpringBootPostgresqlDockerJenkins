pipeline {
    agent any
    environment {
        MAVEN_ARGS=" -e clean install"
        registry = ""
        dockerContainerName = 'bookapi'
        dockerImageName = 'bookapi-api'
    }
    stages {
        stage('Build') {
            steps {
                withMaven(maven: 'MAVEN_ENV') {
                    bat "mvn ${MAVEN_ARGS}"
                }
            }
        }

        stage('clean container') {
            steps {
                bat "docker ps -a -f name=%dockerContainerName% -q | for /f 'tokens=*' %i in ('docker container stop $_') do @echo off & docker container stop %i"
                bat "docker ps -a -f name=%dockerContainerName% -q | for /f 'tokens=*' %i in ('docker container rm $_') do @echo off & docker container rm %i"
                bat "for /f 'tokens=*' %i in ('docker images -q –filter=reference=%dockerImageName%') do @echo off & docker rmi -f %i"
            }

        }
        stage('docker-compose start') {
            steps {
                bat 'docker-compose up -d'
            }
        }
    }
}
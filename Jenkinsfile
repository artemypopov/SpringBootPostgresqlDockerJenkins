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
                bat 'docker ps -a -f name=dockerContainerName -q | foreach docker container stop $_'
                bat 'docker ps -a -f name=dockerContainerName -q | foreach docker container rm $_'
                bat 'docker images -q –filter=reference=dockerImageName | foreach docker rmi -f $_'
            }
        }
        stage('docker-compose start') {
            steps {
                bat 'docker-compose up -d'
            }
        }
    }
}
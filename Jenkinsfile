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
        stage('docker-compose start') {
            steps {
                bat 'docker-compose up -d'
            }
        }
    }
}
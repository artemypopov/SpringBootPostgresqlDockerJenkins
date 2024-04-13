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
                bat 'docker ps -f name=${dockerContainerName} -q | xargs --no-run-if-empty docker container stop'
                bat 'docker container ls -a -f name=${dockerContainerName} -q | xargs -r docker container rm'
                bat 'docker images -q --filter=reference=${dockerImageName} | xargs --no-run-if-empty docker rmi -f'
            }
        }
        stage('docker-compose start') {
            steps {
                bat 'docker-compose up -d'
            }
        }
    }
}
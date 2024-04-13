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
                bat '''
                    docker ps -f name=${dockerContainerName} -q | ForEach-Object { docker container stop $_ }
                    docker container ls -a -f name=${dockerContainerName} -q | ForEach-Object { docker container rm -f $_ }
                    docker images -q --filter=reference=${dockerImageName} | ForEach-Object { docker rmi -f $_ }
                '''
            }
        }
        stage('docker-compose start') {
            steps {
                bat 'docker-compose up -d'
            }
        }
    }
}
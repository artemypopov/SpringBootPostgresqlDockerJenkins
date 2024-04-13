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
//             steps {
//                 sh 'docker ps -a -f name=dockerContainerName -q | foreach docker container stop $_'
//                 sh 'docker ps -a -f name=dockerContainerName -q | foreach docker container rm $_'
//                 sh 'docker images -q –filter=reference=dockerImageName | foreach docker rmi -f $_'
//             }
//             steps {
//                 bat 'docker ps -a -f "name=dockerContainerName" -q > containers.txt'
//                 bat 'for /f "delims=" %i in (containers.txt) do docker container stop %i'
//                 bat 'for /f "delims=" %i in (containers.txt) do docker container rm %i'
//                 bat 'for /f "delims=" %i in ('docker images -q -filter=reference=dockerImageName') do docker rmi -f %i' del containers.txt
//             }
            steps {
                bat 'docker ps -a -f "name=dockerContainerName" -q > containers.txt'
                bat 'for /f "delims=" %%i in (containers.txt) do (docker container stop %%i & docker container rm %%i)'
                bat 'for /f "delims=" %%i in ('docker images -q -f "reference=dockerImageName"') do docker rmi -f %%i' del containers.txt
            }
        }
        stage('docker-compose start') {
            steps {
                bat 'docker-compose up -d'
            }
        }
    }
}
pipeline {
    agent any

    tools {
        gradle 'gradle'
    }

    environment {
        DOCKER_IMAGE = 'cryztal134/spring-boot-demo:latest'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/cryztal/DemoForDocker.git'
            }
        }

    stage('Set Permissions') {
                steps {
                    sh 'chmod +x ./gradlew'
                }
            }

        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }

        stage('Dependency Check') {
            steps {
                sh './gradlew dependencyCheckAnalyze'
            }
        }
    }

    post {
        always {
            cleanWs()
        }
        success {
            echo 'Build and deployment successful!'
        }
        failure {
            echo 'Build or deployment failed.'
        }
    }
}
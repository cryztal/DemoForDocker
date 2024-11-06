pipeline {
    agent any

    tools {
        jdk 'JDK 17'
        gradle 'Gradle 7.4'
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

        stage('Docker Build') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Docker Push') {
            steps {
                sh 'docker push $DOCKER_IMAGE'
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
pipeline {
    agent any

    tools {
        gradle 'gradle'
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
                sh './gradlew dependencyCheckPurge'
                sh './gradlew dependencyCheckAnalyze'
            }
        }
        stage('Install yamllint') {
            steps {
                sh 'pip install yamllint'
            }
        }

        stage('Lint YAML files') {
            steps {
                sh 'yamllint -c .yamllint src/main/resources'
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
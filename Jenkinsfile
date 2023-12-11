pipeline {
    agent any
    tools {
        maven "3.9.6"
    }
    stages {
        stage ('Build') {
            steps {
                sh 'mvn --version'
                sh 'mvn clean install'
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
pipeline {
    agent any
    tools {
        maven 'MAVEN'
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
pipeline {
    
    agent { dockerfile true }
     
    
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
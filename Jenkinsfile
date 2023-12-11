pipeline {
    
    agent { dockerfile true }
     
    
    stages {
        stage ('Build') {
            steps {
                sh 'sudo usermod -a -G docker jenkins'
                sh 'chmod 777 /var/run/docker.sock'
                sh 'mvn --version'
                sh 'mvn clean install'
            }
        }
    }
    /*
    post {
        always {
            cleanWs()
        }
    }
    */
}
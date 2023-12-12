pipeline {
    
    agent { 
        label "docker"
        dockerfile {
            label "docker"
            args "-v /tmp/maven:/home/jenkins/.m2 -e MAVEN_CONFIG=/home/jenkins/.m2"
        }

     }
     
    
    stages {
        stage ('Build') {
            steps {
                sh 'sudo groupadd docker'
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
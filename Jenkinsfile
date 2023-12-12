pipeline {
    
    agent { 
        dockerfile {
            label "mestre"
            args "-v /tmp/maven:/home/jenkins/.m2 -e MAVEN_CONFIG=/home/jenkins/.m2"
        }

     }
     
    
    stages {
        stage ('Build') {
            steps {
                sh 'ls /opt'
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
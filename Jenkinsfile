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
                sh 'mvn --version'
                sh 'sudo mkdir -p /.m2/repository'
                sh 'sudo mvn clean install -e -X'
                
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
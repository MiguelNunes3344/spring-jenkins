pipeline {
    
    agent { 
        dockerfile {
            label "mestre"
            args "-v /tmp/maven:/.m2 -e MAVEN_CONFIG=/.m2"
        }

     }
     
    
    stages {
        stage ('Build') {
            steps {
                sh 'mvn --version'
                sh 'mvn clean install -e'
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
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
                sh 'mkdir -p /.m2/repository'
                sh 'mvn clean install -e -X'
            }
        }
        stage ('Deploy') {
            steps {
                sh 'mvn spring-boot:run'
                
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
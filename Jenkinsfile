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
                sh 'chmod -R a+rw /.m2/repository'
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
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
                sh 'chmod -R u+rwX,go+rX,go-w /.m2/repository'
                sh 'mvn clean install -e -X'
                
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
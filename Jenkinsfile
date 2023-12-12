pipeline {
    
    agent { 
        dockerfile {
            label "mestre"
            args "-v /tmp/maven:/home/jenkins/ -e MAVEN_CONFIG=/home/jenkins/"
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
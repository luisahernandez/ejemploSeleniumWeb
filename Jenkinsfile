pipeline {
    agent any
    stages {
       stage('Clean & Install') {
            steps {
                sh "mvn clean install"
            }
        }

        stage('Run!!!') {
            steps {
                sh "mvn spring-boot:run &"
            }
        }

        stage('Tutooooooo 60 segundos') {
            steps {
                sh 'sleep 60'
            }
        }

        stage('Test selenium') {
            steps {
                sh "mvn test"
            }
        }
        
        
    }
}
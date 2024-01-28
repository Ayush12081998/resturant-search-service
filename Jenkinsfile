pipeline {
    agent { 
    label 'linux'
    }
    stages {
        stage('Build') { 
            steps {
                bat 'mvn -B -DskipTests clean package' 
            }
        }
    }
}

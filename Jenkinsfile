pipeline {
    agent any

    stages {
        stage('Build automation') {
            tools {
                maven 'maven'
            }
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/A00477253/devops-crud']])
                bat 'mvn clean install'
            }
        }
}
}
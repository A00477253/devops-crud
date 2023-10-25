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
        stage('Build Docker image'){
            steps{
                script{
                    bat 'docker build -t viggii1963/devops-integration .'
                }
            }
        }
        stage('Push image to hub'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')])
                    {


                        bat 'docker login -u viggii1963 -p ${dockerhubpwd}'
                        bat 'docker push viggii1963/devops-integration'
                    }

                }
            }
        }
        stage('Docker Deploy'){
        steps{
            bat 'docker run -p 8081:8081 viggii1963/devops-integration '
        }
        }
    }
}
pipeline {
     agent any
     tools{
         maven 'maven_3_9_6'
     }
     
     stages{
         stage('Build maven project'){
             steps{
                 checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/rohit-lodhi1/CICD']]) 
                 bat 'mvn clean install'
             }
         }
         
         stage('Docker Build image'){
             steps{
                     bat 'docker build -t eureka-server .'
             }
         }
         
         stage('Push Docker image to hub')	{
             steps{
              withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerPwd')]) {
               bat 'docker login -u rohitlodhi -p Rohit987123'
               }
               bat 'docker tag eureka-server:latest rohitlodhi/eureka-server:latest'
               bat 'docker push rohitlodhi/eureka-server:latest'
             }
         }
     }
}
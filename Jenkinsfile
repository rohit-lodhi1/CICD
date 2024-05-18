pipeline {
     agent any
     
     environment {
        DOCKER_IMAGE_NAME = 'eureka-server'
        DOCKER_REGISTRY = 'rohitlodhi' // e.g., docker.io/your-username
        KUBERNETES_DEPLOYMENT_NAME = 'eureka-server'
        KUBERNETES_NAMESPACE = 'jenkins' // Default namespace can be 'default'
    }
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
         
         stage('Push Docker image to hub'){
             steps{
              withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerPwd')]) {
               bat 'docker login -u rohitlodhi -p Rohit987123'
               }
               bat 'docker tag eureka-server:latest rohitlodhi/eureka-server:latest'
               bat 'docker push rohitlodhi/eureka-server:latest'
             }
         }
          
            stage('Deploy to Kubernetes') {
               steps {
                      bat """
                        kubectl apply -f k8s-deployment.yaml
                        """
               }
            }
         
     }
    
}

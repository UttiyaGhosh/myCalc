pipeline {
		environment {
    registry = "uttiya/calc"
    registryCredential = 'DockerHub'
    dockerImage = ''
    dockerImageLatest = ''
  }
  triggers {
        pollSCM 'H/2 * * * *'
    }
  agent any
  stages {
    stage('Cloning Git') {
      steps {
        git 'https://github.com/UttiyaGhosh/myCalc.git'
      }
    }
    stage('Unit Test'){
        steps {
             sh 'mvn test'
        }
    }
    stage('Build Jar'){
        steps {
             sh 'mvn clean install'
        }
    }
    stage('Build Image') {
      steps{
        script {
          dockerImage = docker.build registry + ":$BUILD_NUMBER"
          dockerImageLatest = docker.build registry + ":latest"
        }
      }
    }
    stage('Deploy Image') {
      steps{
        script {
          docker.withRegistry( '', registryCredential ) {
            dockerImage.push()
            dockerImageLatest.push()
          }
        }
      }
    }
    stage('Remove Unused Docker image') {
      steps{
        sh "docker rmi $registry:$BUILD_NUMBER"
      }
    }
    stage('Execute Rundeck job') {
        steps {
          script {
            step([$class: "RundeckNotifier",
                  includeRundeckLogs: true,
                  jobId: "f5e40943-bcdc-4804-a1da-061128e865e2",
                  rundeckInstance: "myCalc",
                  shouldFailTheBuild: true,
                  shouldWaitForRundeckJob: true,
                  tailLog: true])
          }
        }
    }
  }
}

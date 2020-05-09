pipeline {
		environment {
    registry = "uttiya/calc"
    registryCredential = 'DockerHub'
    dockerImage = ''
    dockerImageLatest = ''
  }
  agent any
  stages {
    stage('Cloning Git') {
      steps {
        git 'https://github.com/UttiyaGhosh/myCalc'
      }
    }
    stage('Build'){
        steps {
             sh 'mvn clean install'
        }
    }
    stage('Test'){
        steps {
             sh 'mvn test'
        }
    }
    stage('Building image') {
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
    stage('Remove Unused docker image') {
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
                  rundeckInstance: "testlabel",
                  shouldFailTheBuild: true,
                  shouldWaitForRundeckJob: true,
                  tailLog: true])
          }
        }
    }
  }
}

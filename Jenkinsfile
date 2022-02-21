pipeline {
  agent { label 'linux' }
  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }
  stages {
    stage('invoke playbook'){
      sh '''
      ansible --version
      '''
  }
}

pipeline {
  agent { label 'linux' }
  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }
  stages {
    stage('Scan') {
      steps {
        withSonarQubeEnv(installationName: 'sq1') { 
          sh 'mvn clean org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.0.2155:sonar'
        }
      }
    }
    stage('invoke playbook'){
      steps{
				ansiblePlaybook credentialsId: 'DigitalOceanUser', installation: 'Ansible', inventory: '/etc/ansible/hosts', playbook: './playbook.yaml'               			}
   	}
  }
}

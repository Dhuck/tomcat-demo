pipeline {
  agent { label 'linux' }
  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }
	environment {
	  ANSIBLE_PRIVATE_KEY=credentials('Vagrant')
	}
stages {
    stage('invoke playbook'){
      steps {
	    sh 'ansible-playbook -i /etc/ansible/hosts --private-key=Vagrant playbook.yaml'
      }
	}
  }
}

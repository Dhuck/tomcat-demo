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
	    sh 'ansible all -m ping -vvv'
	    sh 'ansible-playbook -i /etc/ansible/hosts -u vagrant --private-key=$ANSIBLE_PRIVATE_KEY playbook.yaml'
      }
	}
  }
}

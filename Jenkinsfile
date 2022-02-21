pipeline {
  agent { label 'linux' }
  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }
	environment {
	  ANSIBLE_PRIVATE_KEY=credentials('DigitalOceanUser')
	}
stages {
    stage('invoke playbook'){
      steps {
	    sh '''
	      ansible-playbook -u vagrant -i /etc/ansible/hosts playbook.yaml
        '''
      }
	}
  }
}

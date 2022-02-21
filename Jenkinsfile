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
              ansible --version
	      ansible-playbook -u vagrant -i /etc/ansible/hosts --private-key=$ANSIBLE_PRIVATE_KEY ./playbook.yaml
        '''
      }
	}
  }
}

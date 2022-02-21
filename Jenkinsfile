pipeline {
  agent { label 'linux' }
  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }
	environment {
	  ANSIBLE_PRIVATE_KEY=credentials('vagrant')
	}
stages {
    stage('invoke playbook'){
      steps {
	    sh '''
              ansible --version
	      ansible-playbook -i /etc/ansible/hosts --private-key=$ANSIBLE_PRIVATE_KEY ./playbook.yaml
        '''
      }
	}
  }
}

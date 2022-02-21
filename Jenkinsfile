pipeline {
  agent { label 'linux' }
  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }
stages {
    stage('invoke playbook'){
      steps {
	    sh '''
          ansible --version
		  ansible-playbook --version
        '''
      }
	}
  }
}

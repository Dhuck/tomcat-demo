pipeline {
  agent { label 'linux' }
  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }
  environment {
    ANSIBLE_PRIVATE_KEY=credentials('Vagrant')
    ANSIBLE_HOST_KEY_CHECKING='False'
  }
stages {
    stage('invoke playbook'){
      steps {
	    //sh 'ansible-playbook -i /etc/ansible/hosts playbook.yaml'
	      ansiblePlaybook credentialsId: 'DigitalOceanUser', disableHostKeyChecking: true, installation: 'Ansible', inventory: '/etc/ansible/hosts', playbook: 'playbook.yaml'
      }
	}
  }
}

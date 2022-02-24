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
          sh 'echo "Ansible"'
          //sh 'ansible-playbook -i /etc/ansible/hosts playbook.yaml'
          //ansiblePlaybook disableHostKeyChecking: true, installation: 'Ansible', inventory: '/etc/ansible/hosts', playbook: 'playbook.yaml'
      }
    }
    stage('Scan') {
      steps {
          sh 'mvn clean install'
      }
    }
    stage('OWASP Scan') {
      steps {
          sh '/home/hpolanco/dependency-check/bin/dependency-check.sh --project "NATASEC" -scan "target/*.war" -f CSV'
      }
    }
	
  }
}

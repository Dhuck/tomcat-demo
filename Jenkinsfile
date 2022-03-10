pipeline {
  agent { label 'linux' }
  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }
  environment {
    ANSIBLE_PRIVATE_KEY=credentials('hpolanco')
    ANSIBLE_HOST_KEY_CHECKING='False'
  }
stages {
    stage('invoke playbook'){
      steps {
          sh 'echo "Ansible Provisioning"'
	  sh 'ansible all -m ping -vvv'
          sh 'ansible-playbook -i /etc/ansible/hosts playbook.yaml'
          //ansiblePlaybook disableHostKeyChecking: true, installation: 'Ansible', inventory: '/etc/ansible/hosts', playbook: 'playbook.yaml'
      }
    }
    stage('Scan') {
      steps {
          withSonarQubeEnv(installationName: 'sq1') { 
          sh 'mvn clean org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.0.2155:sonar'
        }
      }
    }
    stage('OWASP Scan') {
      steps {
          sh '/home/vagrant/dependency-check/bin/dependency-check.sh --project "NATASEC" -scan "target/*.war" -f JSON'
      }
    }
	
  }
}

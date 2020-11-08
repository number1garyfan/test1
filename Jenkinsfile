pipeline {
	agent {
		docker {
			image 'composer:latest'
		}
	}
	stages {
		stage('Build') {
			steps {
				sh 'composer install'
			}
		}
		stage('Test') {
			steps {
              		     sh './vendor/bin/phpunit --log-junit logs/unitreport.xml -c Team-01/jenkins-phpunit-test/tests/phpunit.xml Team-01/jenkins-phpunit-test/tests'
			}
		}
	}
	post {
		always {
			junit testResults: 'logs/unitreport.xml'
		}
	}
}

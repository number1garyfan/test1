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
              		     sh './vendor/bin/phpunit --log-junit logs/unitreport.xml -c jenkins-phpunit-test/tests/phpunit.xml jenkins-phpunit-test/tests'
			}
		}
	}
	post {
		always {
			junit testResults: 'logs/unitreport.xml'
		}
	}
}

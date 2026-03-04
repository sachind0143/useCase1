pipeline {

    agent any

    tools {
        maven 'Maven3'
    }

    parameters {

        choice(
            name: 'BROWSER',
            choices: ['chrome','firefox','edge'],
            description: 'Select browser'
        )

        choice(
            name: 'ENV',
            choices: ['QA','UAT'],
            description: 'Environment'
        )
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                url: 'https://github.com/YOUR_REPO.git'
            }
        }

        stage('Build Project') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Automation Tests') {
            steps {
                bat "mvn test -Dbrowser=%BROWSER%"
            }
        }

        stage('Publish Test Report') {
            steps {
                publishHTML([
            reportDir: 'reports',
            reportFiles: 'ExtentReport.html',
            reportName: 'Automation Test Report',
            keepAll: true,
            alwaysLinkToLastBuild: true,
            allowMissing: true
                ])
            }
        }

    }

    post {

        always {

            archiveArtifacts artifacts: 'reports/screenshots/*.png'

            junit 'target/surefire-reports/*.xml'
        }

        success {
            echo 'Automation executed successfully!'
        }

        failure {
            echo 'Automation failed. Check report.'
        }
    }
}

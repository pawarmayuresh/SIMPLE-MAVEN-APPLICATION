pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                script {
                    try {
                        checkout scm
                    } catch (err) {
                        git branch: 'main', url: 'https://github.com/pawarmayuresh/SIMPLE-MAVEN-APPLICATION.git'
                    }
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn -B -DskipTests clean compile'
                    } else {
                        bat 'mvn -B -DskipTests clean compile'
                    }
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn -B test'
                    } else {
                        bat 'mvn -B test'
                    }
                }
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}

pipeline {
  agent any
  stages {
    stage('Build DEV') {
      parallel {
        stage('Build deV') {
          steps {
            sh 'mvn clean install -DskipTests=true'
          }
        }

        stage('run test on dev') {
          steps {
            sh 'mvn test -Denv=dev'
          }
        }

      }
    }

    stage('Build QA') {
      parallel {
        stage('Build QA') {
          steps {
            sh 'mvn compile'
          }
        }

        stage('run test on qa') {
          steps {
            sh 'mvn test -Denv=qa'
          }
        }

      }
    }

    stage('Build stage') {
      parallel {
        stage('Build stage') {
          steps {
            sh 'mvn compile'
          }
        }

        stage('no env run') {
          steps {
            sh 'mvn test'
          }
        }

      }
    }

  }
}
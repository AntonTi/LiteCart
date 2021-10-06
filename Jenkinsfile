pipeline {
    agent any

    stages{
        stage('Preparation') {
            steps {
                git 'https://github.com/AntonTi/LiteCart.git'
            }
        }
        stage('UI tests') {
            steps{
                bat 'mvn clean -DsuiteXml="testng.xml" test'
            }
        }
    }
}
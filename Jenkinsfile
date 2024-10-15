pipeline {
    agent {
        docker {
            image 'docker:latest' // Docker image utilisée pour exécuter les étapes du pipeline
            args '-v /var/run/docker.sock:/var/run/docker.sock' // Montage du socket Docker pour accéder au daemon Docker
        }
    }
    environment {
        DOCKER_HUB_REPO = 'sadokgaied/pipeline1'  // Nom de votre dépôt DockerHub
        DOCKER_CREDENTIALS_ID = 'sadok1'  // ID des credentials DockerHub
    }
    stages {
        stage('Checkout') {
            steps {
                // Clone the repository from GitHub
                git 'https://github.com/sadokgaied123/partie_91.git'
            }
        }
        stage('Build') {
            steps {
                // Build the Docker image
                script {
                    dockerImage = docker.build("${DOCKER_HUB_REPO}:latest")
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', "${DOCKER_CREDENTIALS_ID}") {
                        dockerImage.push()
                    }
                }
            }
        }
        stage('Clean Up') {
            steps {
                // Clean up after the build
                sh "docker rmi ${DOCKER_HUB_REPO}:latest"
            }
        }
    }
}

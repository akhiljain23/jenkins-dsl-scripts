pipeline {
    agent {
        label ''
    }
    environment {
        IBMCLOUD_ENVIRONMENT = "prod"
        REGION = "us-south"
    }
    stages {
        stage('Discover Vault Secrets') {
            steps {
                script {
                    currentBuild.description = "$IBMCLOUD_ENVIRONMENT"
                    sh """
                    echo "$REGION"
                    """
                }
            }
        }
    }
}

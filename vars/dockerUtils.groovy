// vars/dockerUtils.groovy
def buildAndPushDockerImage(String imageName, String imageTag) {
    pipeline {
        agent any
        stages {
            stage('Build & Tag Docker Image') {
                steps {
                    script {
                        withDockerRegistry(credentialsId: 'docker_cred', toolName: 'docker') {
                            sh "docker build -t ${imageName}:${imageTag} ."
                        }
                    }
                }
            }
            stage('Push Docker Image') {
                steps {
                    script {
                        withDockerRegistry(credentialsId: 'docker_cred', toolName: 'docker') {
                            sh "docker push ${imageName}:${imageTag}"
                        }
                    }
                }
            }
        }
    }
}

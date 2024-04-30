// vars/dockerUtils.groovy
def buildImage(String imageName, String imageTag) {
    stage('Build & Tag Docker Image') {
                steps {
                    script {
                        withDockerRegistry(credentialsId: 'docker_cred', toolName: 'docker') {
                            sh "docker build -t ${imageName}:${imageTag} ."
                        }
                    }
                }
            }
}

def pushImage(String imageName, String imageTag) {
    stage('Push Docker Image') {
            steps {
                script {
                    withDockerRegistry(credentialsId: 'docker_cred', toolName: 'docker') {
                        sh "docker push ${imageName}:${imageTag} "
                    }
                }
            }
        }  
}

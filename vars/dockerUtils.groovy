// vars/dockerUtils.groovy
def buildImage(String imageName, String imageTag) {
    sh "docker build -t ${imageName}:${imageTag} ."
}

def pushImage(String imageName, String imageTag) {
    sh "docker build -t ${imageName}:${imageTag} ."
}

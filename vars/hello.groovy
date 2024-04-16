def call(String tag,String file_name) {
   script {
            withDockerRegistry(credentialsId: 'docker-cred', toolName: 'docker') {
            sh "docker build -t aak11/adservice:latest ."
            }
        }
}

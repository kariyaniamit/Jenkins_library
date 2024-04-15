def build(String tag,String file_name) {
    sh """
        docker build --build-arg file_name="${file_name}" -t "${tag}"  .
    """
}

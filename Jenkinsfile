node {
    def app

    stage('Clone repository') {
        /* Let's make sure we have the repository cloned to our workspace */

        checkout scm
    }

    stage('Build image') {
        /* This builds the actual image; synonymous to
         * docker build on the command line */

        app = docker.build("sdnsoft/marketplace:discovery-server-0.0.1-SNAPSHOT")
    }

    stage('Test image') {
        /* We need to add test steps in this section */

        app.inside {
            sh 'echo "Tests passed"'
        }
    }

    stage('Push image') {
        /* push the image with two tags:
         * First, the incremental build number from Jenkins
         * Second, the 'latest' tag. */
         
        docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }
    }
}

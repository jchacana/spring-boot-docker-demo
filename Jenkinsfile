node {

    stage('Prepare') {
        sh 'java -version'
        sh 'which java'
    }

    stage('Clone sources') {
        git url: 'https://github.com/jchacana/spring-boot-docker-demo.git'
    }

    stage('Maven build') {
        withMaven(
            // Maven installation declared in the Jenkins "Global Tool Configuration"
            maven: 'maven',
            // Maven settings.xml file defined with the Jenkins Config File Provider Plugin
            // Maven settings and global settings can also be defined in Jenkins Global Tools Configuration
            mavenLocalRepo: '.repository') {

            // Run the maven build
            sh "mvn clean install"
            sh "mvn dockerfile:build"

        } // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe & FindBugs reports...

    }

    pom = readMavenPom file: 'pom.xml'
    repo = pom.properties['docker.image.prefix']
    version = pom.version
    stage('Docker push') {

        sh "echo " + version
        sh "echo " + repo

        docker.withRegistry('', 'dockerhub') {
            def customImage = docker.image(repo + '/spring-boot-docker:'+version)
            customImage.push(version)
            customImage.push('latest')
        }
    }

}
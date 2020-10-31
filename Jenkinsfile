pipeline {

    agent {
        label 'master' //The id of the slave/agent where the build should be executed, if it doesn't matter use "agent any" instead.
    }

    triggers {
        pollSCM('* * * * *') //polling for changes, here once a minute
    }

    stages {
      /*
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']],
                doGenerateSubmoduleConfigurations: false,
                extensions: [], submoduleCfg: [],
                userRemoteConfigs: [[url: 'https://github.com/allmankind123/king-web.git']]])
            }
        }
      */
        stage('Unit & Integration Tests') {
            steps {
                script {
                    try {
                        sh 'cd web-hello-world; /opt/gradle/gradle-5.0/bin/gradle  clean test   --no-daemon '  //run a gradle task
                    } finally {
                        junit '**/build/test-results/test/*.xml' 
                    }
                }
            }
        }
        stage('build and archive war') {
            steps {
                sh 'cd web-hello-world; /opt/gradle/gradle-5.0/bin/gradle  war   --no-daemon ' 
                archiveArtifacts 'web-hello-world/build/libs/*.war'
                
            }
        }
    }
}


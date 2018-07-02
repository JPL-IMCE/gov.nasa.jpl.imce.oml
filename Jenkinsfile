pipeline {
    
    agent {
         label 'IMCE'
    }
    
    stages {
    	stage('Docker Login') {
    		steps {
    			withCredentials([ 
    				usernamePassword(
    					credentialsId: 'caesar.docker.credentials', 
    					passwordVariable: 'DOCKER_PASSWORD', 
    					usernameVariable: 'DOCKER_USERID')
    				]) {
    					sh "docker login -u \"$DOCKER_USERID\" -p \"$DOCKER_PASSWORD\""                                                             
    			    }
    		}
    	}
    	
    	stage('Get Docker Image') {
    		steps {
    			sh "docker pull maven:3.5-jdk-8"
    		}
    	}

        stage('Run Dockerized Build') {
            steps {
            	sh """
            	docker \
        			run \
        			--rm \
        			-v \$(pwd):/root/sources \
        			-w /root/sources \
        			maven:3.5-jdk-8 \
        			./scripts/travis.sh
      			"""       
               	
            }

        }

    }


}

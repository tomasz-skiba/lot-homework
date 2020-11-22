# Project run

- Start docker

	    docker-compose up --build
	
- If IP mapping problem occurred add ENV `MYSQL_ROOT_HOST=ip_to_host_from_docker_machine` to `docker-compose.yml` 
This given address should be an address how Docker machine identifies host computer

- Go to `IpApi` folder and execute command:

	    mvn spring-boot:run

Application `Swagger` GUI will be available at your docker IP at port 8081

# Project Eclipse setup

- import project IpApi to Eclipse  

    	file -> import ->Existing Maven Project
- import launch configuration from `Build` folder 

    	file -> import ->Launch Configurations

- Update project dependencies rightclick project ->Maven -> Update Maven project
	
- From project directory execute shell command

    	docker-compose up --build
	
If ip mapping problem occurred add ENV `MYSQL_ROOT_HOST=ip_to_host_from_docker_machine` to `docker-compose.yml` 

If docker error occures:

	lot-maria-db  | standard_init_linux.go:211: exec user process caused "no such file or directory"
	lot-maria-db exited with code 1
	
Please change `Build\mariadb\10.4\docker-entrypoint.sh` file EOL conversion to Unix, then retry `docker-compose up --build`

- Run application using `IpApiApplication` launch configuration

- Application API should be available at port `8081`

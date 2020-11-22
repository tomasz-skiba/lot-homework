# Project setup

clone repository to your local device

import project IpApi to Eclipse  file -> import ->Existing Maven Project
import launch configuration from Build folder file -> import ->Launch Configurations

update project dependencies rightclick project ->Maven -> Update Maven project


Create file 'env.env' in root path of project.
The 'env.env' file should contain variables:

	MYSQL_ROOT_PASSWORD=password_to_db_root_user
	MYSQL_ROOT_HOST=ip_to_your_docker_machine

Add to your hosts file record
	
	skiba-host.local ip_to_your_docker_machine
	
Update application.properties file with your data.

	spring.datasource.password=password_for_db_root_user

Update hibernate.cfg.xml file with your data

	<property name="hibernate.connection.password">password_for_db_root_user</property>
	
From project directory execute shell command
	docker-compose up --build
	
If you see error:
	lot-maria-db  | standard_init_linux.go:211: exec user process caused "no such file or directory"
	lot-maria-db exited with code 1
Please change file EOL conversion to Unix

Run application using `IpApiApplication` launch configuration

Application API should be available at 
	http://skiba-host.local:8081/
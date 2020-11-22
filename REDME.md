# Project setup

clone repository to your local device

import project IpApi to Eclipse  file -> import ->Existing Maven Project
import launch configuration from Build folder file -> import ->Launch Configurations

update project dependencies rightclick project ->Maven -> Update Maven project


Create file '.emv' in root path of project.
The '.emv' file should contain variables:

	MYSQL_ROOT_PASSWORD={password for db root user}
	MYSQL_ROOT_HOST={ip to your docker machine}

Add to your hosts file record
	
	skiba-host.local {ip to your docker machine}
	
Update application.properties file with your data.

	spring.datasource.password={password for db root user}

Update hibernate.cfg.xml file with your data

	<property name="hibernate.connection.password">{password for db root user}</property>
	
From project directory execute shell command
	docker-compose up --build
	
If you see error:
	lot-maria-db  | standard_init_linux.go:211: exec user process caused "no such file or directory"
	lot-maria-db exited with code 1
Please change file EOL conversion to Unix

Run application using `IpApiApplication` launch configuration

Application API should be available at 
	http://skiba-host.local:8081/
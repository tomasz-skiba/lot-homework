# Project setup

Create file '.emv' in root path of project.
The '.emv' file should contain variables:

	MYSQL_ALLOW_EMPTY_PASSWORD=no
	MYSQL_ROOT_PASSWORD={your_data_here}
	MYSQL_ROOT_USER={your_data_here}
	MYSQL_ROOT_HOST={your_data_here}
	MYSQL_USER={your_data_here}
	
Update application.properties file with your data.

	spring.datasource.url=jdbc:mysql://{your_data_here}:3306/lot-maria-db
	spring.datasource.username={your_data_here}
	spring.datasource.password={your_data_here}
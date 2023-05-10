FROM 		tomcat:8.0.21-jre8

MAINTAINER 	"leonardo.larraquy@gmail.com"

COPY 		./target/demoapp-0.1.war /usr/local/tomcat/webapps/demoapp.war

EXPOSE 8080
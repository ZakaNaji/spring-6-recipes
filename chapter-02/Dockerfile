# Use the official Tomcat base image with JDK 17
FROM tomcat:10.1-jdk17-temurin

# Add custom logging configuration
COPY logging.properties /usr/local/tomcat/conf/logging.properties

# Set environment variables
ENV CATALINA_HOME /usr/local/tomcat
ENV PATH $CATALINA_HOME/bin:$PATH
ENV JPDA_ADDRESS 8000
ENV JPDA_TRANSPORT dt_socket

# Remove default webapps to keep the container lightweight
RUN rm -rf $CATALINA_HOME/webapps/*

# Copy the WAR file to the Tomcat webapps directory
COPY target/chapter-02.war $CATALINA_HOME/webapps/ROOT.war

# Expose the Tomcat server port and the debug port
EXPOSE 8080 8000

# Start the Tomcat server in JPDA mode for remote debugging
CMD ["catalina.sh", "jpda", "run"]

# Use the official Tomcat base image with JDK 17
FROM tomcat:10.1-jdk17-temurin

# Add custom logging configuration
COPY logging.properties /usr/local/tomcat/conf/logging.properties

# Set environment variables
ENV CATALINA_HOME /usr/local/tomcat
ENV PATH $CATALINA_HOME/bin:$PATH

# Remove default webapps to keep the container lightweight
RUN rm -rf $CATALINA_HOME/webapps/*

# Copy the WAR file to the Tomcat webapps directory
COPY target/chapter-02.war $CATALINA_HOME/webapps/ROOT.war

# Expose the Tomcat server port
EXPOSE 8080

# Start the Tomcat server
CMD ["catalina.sh", "run"]

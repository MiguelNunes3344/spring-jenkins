FROM maven:latest
USER root
RUN mkdir -p /var/jenkins_home/.m2/repository && \
    chmod -R 777 /var/jenkins_home/.m2





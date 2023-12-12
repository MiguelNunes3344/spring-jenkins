FROM maven:latest
USER root
RUN mkdir -p /var/jenkins_home/.m2/repository && \
    chmod -R 777 /var/jenkins_home/.m2
USER jenkins
RUN useradd -m -u 1000 -s /bin/bash jenkins



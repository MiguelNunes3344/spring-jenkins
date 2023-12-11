FROM maven:latest
RUN 
RUN usermod -a -G docker jenkins
RUN useradd -m -u 1000 -s /bin/bash jenkins


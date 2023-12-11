FROM maven:latest
RUN sudo usermod -a -G docker jenkins
RUN useradd -m -u 1000 -s /bin/bash jenkins


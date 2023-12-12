FROM maven:latest
RUN usermod -aG root jenkins
RUN useradd -m -u 1000 -s /bin/bash jenkins



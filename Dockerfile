FROM maven:latest
RUN sudo groupadd docker
RUN useradd -m -u 1000 -s /bin/bash jenkins


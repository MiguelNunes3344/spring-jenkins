FROM maven:latest
RUN sudo groupadd docker
RUN sudo usermod -aG docker jenkins
RUN docker run hello-world
RUN sudo chmod 666 /var/run/docker.sock
RUN useradd -m -u 1000 -s /bin/bash jenkins



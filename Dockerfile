FROM maven:latest
RUN chmod 666 /var/run/docker.sock
RUN useradd -m -u 1000 -s /bin/bash jenkins


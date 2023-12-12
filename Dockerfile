FROM openjdk:17-jdk-slim
RUN ls /opt
RUN useradd -m -u 1000 -s /bin/bash jenkins



FROM maven:latest
USER root
RUN mkdir -p /.m2/repository && \
    chmod -R 777 /.m2/repository





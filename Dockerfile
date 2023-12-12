FROM maven:latest
RUN chmod -R u+rwX,go+rX,go-w ~/.m2/repository
RUN useradd -m -u 1000 -s /bin/bash jenkins



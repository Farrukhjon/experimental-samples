#########################################################
# Instruction for automatically build a doockerized image.
# How to build: docker build Dockerfile
#########################################################

# The FROM instruction sets the Base Image for subsequent instructions.
FROM farrukhjon/ubuntu-oracle-jdk8:latest

# The MAINTAINER instruction allows you to set the Author field of the generated images.
MAINTAINER Farrukhjon SATTOROV firedandy@gmail.com

# The EXPOSE instructions informs Docker that the container will listen on the specified network ports at runtime.
EXPOSE 2020

# The COPY instruction copies new files or directories from <src> and adds them to the filesystem of the container at the path <dest>.
COPY artifacts/gradle-docker-examples.jar /opt/gradle-docker-examples.jar

# The WORKDIR instruction sets the working directory for any RUN, CMD, ENTRYPOINT, COPY and ADD instructions that follow it in the Dockerfile.
# WORKDIR /path/to/workdir.
WORKDIR /opt

# An ENTRYPOINT allows you to configure a container that will run as an executable.
ENTRYPOINT ["java",  "-jar", "gradle-docker-examples.jar"]
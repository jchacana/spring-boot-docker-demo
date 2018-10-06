# Spring-Boot Docker Demo Project

This demo project shows how to run a Spring-Boot application inside a docker container - including 
hot reloading classes.

## Running and Debugging locally:
 - `mvn clean install`
 - `mvn dockerfile:build`
 - `docker-compose up`
 - Visit `http://localhost:8080/` and you should see a **Hello World!** message"
	

## System requirements

You need to have a running Docker installation and docker-compose installed to run this demo. It 
also assumes, that you are using any kind of IDE - it works with Eclipse..

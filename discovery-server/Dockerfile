# use a node base image
FROM openjdk:8-jre-alpine

# set maintainer
LABEL maintainer "Sepehr Safari"

# Add a volume pointing to /tmp
VOLUME /tmp

# Variable arguments defined in pom.xml file
ARG JAR_FILE
ARG PORT
ARG IMG

#Only available at run time
ENV name=${IMG}
ENV port=${PORT}

# Add the application's jar to the container
ADD ${JAR_FILE} ${IMG}

# set a health check
HEALTHCHECK --interval=5s --timeout=5s CMD curl -f http://127.0.0.1:$port || exit 1

# tell docker what port to expose
EXPOSE ${PORT}

# Run the jar file 
ENTRYPOINT exec java -jar /$name

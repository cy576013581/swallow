FROM openjdk:10-jre

WORKDIR /opt/@project.artifactId@/

ADD @project.build.finalName@.jar /opt/@project.artifactId@/@project.build.finalName@.jar

RUN mkdir /opt/@project.artifactId@/work

VOLUME /opt/@project.artifactId@/work

EXPOSE 8090

ENTRYPOINT ["/usr/bin/java", "-jar", "/opt/@project.artifactId@/@project.build.finalName@.jar"]
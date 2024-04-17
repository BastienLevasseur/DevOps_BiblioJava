FROM openjdk:21

COPY *.jar /biblio/

WORKDIR /biblio/

CMD ["java","-jar", "*.jar"]
FROM openjdk:17

EXPOSE 8080

ADD build/libs/buybook-*.jar .

ENTRYPOINT ["java", "-jar", "buybook-*.jar"]

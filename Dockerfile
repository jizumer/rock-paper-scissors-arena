FROM openjdk:11-slim-buster

RUN mkdir /rock_paper_scissors
COPY build/libs/rock-paper-scissors-*.jar /rock_paper_scissors/rps.jar

CMD ["java","-jar","/rock_paper_scissors/rps.jar", "frontend"]
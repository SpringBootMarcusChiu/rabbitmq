https://www.rabbitmq.com/tutorials/tutorial-two-spring-amqp.html

0. assumes RabbitMQ is installed and running on localhost on standard port (5672)

1. compile spring boot into jar
   mvn clean package
   
Can't run both sender and receiver together because SpringBoot would both try to acquire port 8080

2. run sender
   java -jar target/spring-boot-rabbitmq-0.0.1-SNAPSHOT.jar --spring.profiles.active=pub-sub,sender --server.port=8080 --tutorial.client.duration=60000
   
3. run receiver
   java -jar target/spring-boot-rabbitmq-0.0.1-SNAPSHOT.jar --spring.profiles.active=pub-sub,receiver --server.port=8081 --tutorial.client.duration=60000

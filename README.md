# email-service
small service listens to emailQueue of rabbitMQ and send the messages to targeted email then pushes messages to other exchange to be logged as history

# prerequisites
config server should be up and run<br/>
<a href="https://github.com/JavaAdore/config-server">https://github.com/JavaAdore/config-server</a> <br/>
eureka server should be up and run<br/>
<a href="https://github.com/JavaAdore/eureka-server">https://github.com/JavaAdore/eureka-server</a> <br/>
authorization server should be up and run<br/>
<a href="https://github.com/JavaAdore/authorization-server">https://github.com/JavaAdore/authorization-server</a> <br/>


zipkin server nice be up and run so you can track the request<br/>
<a href="https://github.com/JavaAdore/zipkin-server">https://github.com/JavaAdore/zipkin-server</a> <br/>


RabbitMQ <br/>
Ensure rabbitMQ has exchange called "notification.exchange" <br/>
Ensure exchange "notification.exchange" has valid routing for messages with routing key "email" and "sms" ;<br/>
 


 

environment variables should be added

# ZIPKIN_SERVER_IP = 127.0.0.1
127.0.0.1 the ip of machine where zipkin server runs
# SLEUTH_LOGGING_LEVEL=info
level of sleuth loggin

# RABBITMQ_LISTENER_IP = 127.0.0.1
# RABBITMQ_LISTENER_PORT = 5672
# RABBITMQ_DEFAULT_USER = user
change user to username of rabbitmq
# RABBITMQ_DEFAULT_PASS = password
change password to username of rabbitmq


 
# AUTHORIZATION_SERVER_IP=127.0.0.1
# AUTHORIZATION_SERVER_PORT=8888

# EUREKA_SERVER_IP      = 127.0.0.1
# EUREKA_SERVER_PORT    = 8761

# PRODUCT_EMAIL_HOST=smtp.gmail.com
# PRODUCT_EMAIL_PORT=587
# PRODUCT_USER_NAME=java.adore@gmail.com
# PRODUCT_PASSWORD=




# notification-service just listens to emailQueue ( many instants will be created as per load .. will be managed by Kubernetes later on)
void sendEmail(Message message);


 

# build
as root/Administration <br/>
mvn clean install docker:removeImage docker:build
# run
java -jar target/email-server.jar

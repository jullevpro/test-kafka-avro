# Sample project : Avro Kafka messages Producer and Consumer

### Disclaimer

This project is only intended to see how to configure Avro kafka messages for both consumer and producer. 

Nothing is optimized, some dependencies are outdated. 


## Prerequisites

Configure your host file in order to add kafka name pointing to localhost

Open the file "c:/windows/system32/drivers/etc/hosts"

Add the line

        127.0.0.1 kafka


## Instructions

Steps to launch the project

1. Go to docker directory and then
        
        docker compose up
    This will launch all the Kafka stack
2. Compile the project
3. Run the application
4. Open your browser and go to :

        http://localhost:8020
5. Use the Rest Api to produce a message
6. Go to the console of your IDE and look at the logs

## Important files

Configuration :

        resources/application.yaml
        resources/avro/user.asvc

Kafka producer :

        KafkaProducer.java

Kafka consumer :

        KafkaConsumer.java






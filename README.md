# EventProcessor

This contains two applications once producer and one consumer. The producer reads the event objects in JSON and sends it to consumer using JMS and AMQ. 

The consumer application reads the message off the queue and inserts it to MongoDB .

Pre-requisites for running the applications

1.	Java 1.8 
2.	MongoDB installed and mongod running.

To start the applications please execute commands as below

1.	Producer  - java –Dfile.path=<Path to source file with out file name>  -jar event-producer-1.0.0-spring-bootjar
2.	Consumer – java –jar event-consumer-1.0.0-spring-boot.jar

Once the above steps are executed ,place the source file in the –Dfile.path specified in step 1 above. The source file will be read and event objetcs will be inserted to event_repo in collection events in MongoDB.


Each project contains docker file and maven plugins for docker:build. Docker image can be created by running
mvn clean package docker:build from Docker terminal.


# spring-base-gradle

The springboot base gradle project is a simple gradle project with boilerplates included. This code base involves standard code elements while building a springboot microserivices and best practices suggested. It will not include `database` configurations or a `integration` code such as connectors for `kafka` or with cloud services.

### What it has?
1. The application has basic spring boot with gradle as build tool.
2. OAS - 3.0 with swagger UI page.
3. Reference swagger documentation demonstrated with a `healthInfo` api.
4. Junit5 and jacoco configuration for execution of unit test and generation of code coverage report.
5. Sample API test to demonstrate how to do a simple sanity API test.

### Actuator configuration.
The branch holds the details on how to setup actuator and micrometer. Micrometer enables springboot applications to bridge the output into target system. The data is pushed into influxdb at regular time intervals. Influxdb can be configured to drop ageing data there by maintaining the status of the application within a range.

To enable `actuator` add the dependency

`implementation 'org.springframework.boot:spring-boot-starter-actuator'`

To enable `micrometer` include the dependency

`implementation 'io.micrometer:micrometer-registry-influx'`

### Setup Influxdb
**Step 1:** The easy way to setup influx db is by spinning up a docker image. To do that run the command

`docker run --rm --name influx -p 8086:8086 influxdb`

**Step 2:** Once the influx db is up and running login to the influxdb shell using the command.

`docker exec -it influx influx v1 shell`

**Step 3:** Once in shell execute the command.

- `create database springboot`
- `use springboot`

**Step 4:** Get the token from influxdb. 

- `docker exec -it influx influx auth list`

Add the below management configuration to enable connection and push data to influx db.
```
management:
  metrics:
    web:
      exposure:
        include: '*'
    export:
      influx:
        enabled: true
        step: PT10S
        readTimeout: PT30S
        batchSize: 20000
        uri: "http://localhost:8086"
        org: "home" -- This is provided during db creation.
        bucket: "springboot" -- analogous to db.
        token: <token to connect with database.>
```
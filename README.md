![alt tag](https://4.bp.blogspot.com/-ou-a_Aa1t7A/W6IhNc3Q0gI/AAAAAAAAD6Y/pwh44arKiuM_NBqB1H7Pz4-7QhUxAgZkACLcBGAs/s1600/spring-boot-logo.png)

# APLV

## Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.5/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.5/gradle-plugin/reference/html/#build-image)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

## Development

To start your application in the dev profile, run:

```
./gradlew
```

## Building for Development

### Packaging as jar

To build the final jar and optimize the kraken integration application for production, run:

```
./gradlew -Pdev clean bootJar
```

To ensure everything worked, run:

```
java -jar build/libs/*.jar
```


### Packaging as war

To build the final war and optimize the kraken integration application for qa, run:

#### QA with Swagger

```
./gradlew clean bootWar -Pqa -Papi-docs && ./gradlew --stop  
```

#### PRODUCCTION

```
./gradlew clean bootWar -Pprod && ./gradlew --stop  
```

To ensure everything worked, run:

```
java -jar build/libs/*.jar
```

## Swagger

http://localhost:8080/swagger-ui/index.html

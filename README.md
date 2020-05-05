## Protobuf Tutorial

- https://developers.google.com/protocol-buffers/docs/javatutorial

Commands:
    
    //generates proto files
    $ ./gradlew clean build
    
Notes:

- Protobuff plugin looks for proto files inside `src/main/proto`. 

- Proto files are compiled to generate java classes inside `build/generated/source/proto/main/...`

- The compiled Java classes are also added to the classpath as sourceSet.



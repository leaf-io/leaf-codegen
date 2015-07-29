[![Build Status](https://travis-ci.org/leaf-io/leaf-codegen.svg?branch=master)](https://travis-ci.org/leaf-io/leaf-codegen)

# leaf-codegen
leaf-codegen is a code generator based on the [swagger-codegen](https://github.com/swagger-api/swagger-codegen) project.
This project adds the leaf.io code generation languages and templates to the swagger-codegen.

See more on [leaf.io/codegen](http://leaf-io.github.io/leaf-codegen)

## Usage 

        `
        java -jar modules/swagger-codegen-cli/target/leaf-codegen-{version}.jar generate \
          -i http://petstore.swagger.io/v2/swagger.json \
          -l leaf-java \
          -o samples/client/petstore/java
        `
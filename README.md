[ ![Codeship Status for leaf-io/leaf-codegen](https://codeship.com/projects/793d99e0-1525-0133-55c9-6ebb30d8a8ec/status?branch=master)](https://codeship.com/projects/93162)

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
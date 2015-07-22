package io.leaf.codegen;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.factories.SchemaFactoryWrapper;
import io.leaf.codegen.serializer.DoubleSerializer;

/**
 * Created by Andras Toth on 2015.07.21..
 */
public class ModelSchemaGenerator<T> implements SchemaGenerator<T> {

    public ModelSchemaGenerator() {

    }


    @java.lang.Override
    public String generateSchema(Class<T> model) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Double.class, new DoubleSerializer());
        mapper.registerModule(module);

        SchemaFactoryWrapper visitor = new SchemaFactoryWrapper();

        mapper.acceptJsonFormatVisitor(model, visitor);

        JsonSchema schema = visitor.finalSchema();

        return mapper.writeValueAsString(schema);
    }
}

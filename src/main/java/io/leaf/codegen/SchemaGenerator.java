package io.leaf.codegen;

import com.fasterxml.jackson.module.jsonSchema.JsonSchema;

/**
 * Created by Andras Toth on 2015.07.21..
 */
public interface SchemaGenerator<T> {

    String generateSchema(Class<T> model) throws Exception;

}

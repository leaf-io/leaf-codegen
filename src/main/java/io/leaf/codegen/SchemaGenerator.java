package io.leaf.codegen;

/**
 * Created by Andras Toth on 2015.07.21..
 */
public interface SchemaGenerator<T> {

    String generateSchema(Class<T> model);

}

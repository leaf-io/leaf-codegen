package io.leaf.codegen.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Created by Andras Toth on 2015.07.21..
 */
public class DoubleSerializer extends JsonSerializer<Double>{
    @Override
    public void serialize(Double aDouble, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("format", "double");
        jsonGenerator.writeStringField("type", "number");
        jsonGenerator.writeEndObject();
    }

    @Override
    public Class<Double> handledType() {
        return Double.class;
    }
}

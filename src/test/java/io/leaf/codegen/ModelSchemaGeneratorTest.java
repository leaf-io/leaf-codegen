package io.leaf.codegen;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.types.ObjectSchema;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by Andras Toth on 2015.07.21..
 */

public class ModelSchemaGeneratorTest extends TestCase {

    public static class SampleGoodModel {
        @JsonProperty
        public long id;

        @JsonProperty
        public String title;

        @JsonProperty
        public String description;

        @JsonProperty
        public Date created;

        @JsonProperty
        public Double price;
    }


    private SampleGoodModel sampleData;

    @Before
    public void init() {
        sampleData = new SampleGoodModel();
        sampleData.id = 1;
        sampleData.title = "Title";
        sampleData.description = "Description";
        sampleData.created = new Date();
        sampleData.price = 1_000.5;
    }

    @Test(expected = Exception.class)
    public void testModelSchemaGenerationOutput() throws Exception {
        ModelSchemaGenerator<SampleGoodModel> generator = new ModelSchemaGenerator<>();
        String schema = generator.generateSchema(SampleGoodModel.class);
        System.out.print(schema);

        assertNotNull(schema);
    }

}

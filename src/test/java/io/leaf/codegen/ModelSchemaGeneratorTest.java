package io.leaf.codegen;

import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.*;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.Map;

/**
 * Created by Andras Toth on 2015.07.21..
 */

public class ModelSchemaGeneratorTest extends TestCase {

    @SwaggerDefinition(info = @Info(version = "1.0.0", title = "io.leaf"))
    public static class SampleGoodModel {
        @JsonProperty
        @ApiModelProperty(required = true, access = "private")
        public long id;

        @JsonProperty
        @ApiModelProperty(required = true, access = "public", value = "The description of the model.")
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

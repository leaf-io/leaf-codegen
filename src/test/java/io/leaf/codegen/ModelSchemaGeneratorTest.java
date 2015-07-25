package io.leaf.codegen;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by Andras Toth on 2015.07.21..
 */

public class ModelSchemaGeneratorTest extends TestCase {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

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
        logger.info(schema);

        assertNotNull(schema);
    }

}

package io.leaf.codegen;

import io.swagger.codegen.ClientOptInput;
import io.swagger.codegen.ClientOpts;
import io.swagger.codegen.CodegenConfig;
import io.swagger.codegen.DefaultGenerator;
import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;
import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ServiceLoader;

import static java.util.ServiceLoader.load;

/**
 * Created by Gabo on 2015.07.23..
 */
public class JavaLeafGeneratorTest extends TestCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(JavaLeafGeneratorTest.class);

    @Test(expected = Exception.class)
    public void testJavaLeafGenerationOutput() throws Exception {
        ClientOptInput input = new ClientOptInput();

        CodegenConfig config = forName("JavaLeaf");
        if(config != null) {
            String spec = ".\\src\\main\\resources\\SampleGoodModel.json";

            input.setConfig(config);

            Swagger swagger = new SwaggerParser().read(spec, input.getAuthorizationValues(), true);
            new DefaultGenerator().opts(input.opts(new ClientOpts()).swagger(swagger)).generate();
        }
    }

    private static CodegenConfig forName(String name) {
        ServiceLoader<CodegenConfig> loader = load(CodegenConfig.class);
        for (CodegenConfig config : loader) {
            if (config.getName().equals(name)) {
                return config;
            }
        }

        // else try to load directly
        try {
            return (CodegenConfig) Class.forName(name).newInstance();
        } catch (Exception e) {
            LOGGER.error("Can't load config class with name ".concat(name), e);
        }
        return null;
    }
}

package io.leaf.codegen;

import io.swagger.annotations.SwaggerDefinition;
import io.swagger.converter.ModelConverters;
import io.swagger.models.Info;
import io.swagger.models.Swagger;
import io.swagger.util.Json;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

/**
 * Date: 2015.07.23.
 * Time: 8:16
 *
 * @author Andras Toth
 */
public class ModelSchemaGenerator<T> implements SchemaGenerator<T> {
    @Override
    public String generateSchema(Class<T> model) throws Exception {

        Swagger swagger = new Swagger();
        Info info = new Info();

        SwaggerDefinition def = model.getAnnotation(SwaggerDefinition.class);
        info.setVersion(def.info().version());
        info.setTitle(def.info().title());
        Map<String, String> component = new HashMap<>();
        component.put("artifactId", model.getSimpleName());
        component.put("groupId",def.info().title());
        info.setVendorExtension("x-module", component);
        swagger.info(info);

        ModelConverters.getInstance()
                .readAll(model)
                .entrySet()
                .stream()
                .forEach(entry -> {
                    swagger.model(entry.getKey(), entry.getValue());
                });

        return Json.pretty(swagger);

        /*
        return ModelConverters.getInstance()
                .readAll(model)
                .entrySet()
                .stream()
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                e -> {
                                    try {
                                        return new String(Json.pretty(e.getValue()));
                                    }catch(Exception ex){

                                    }
                                    return null;
                                })
                );*/
    }
}

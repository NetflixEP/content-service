package com.polytech.aps.viewvoyage.movie_service.build_db;

import org.jooq.DSLContext;
import org.jooq.codegen.GenerationTool;
import org.jooq.conf.Settings;
import org.jooq.meta.jaxb.*;

public class JooqCodegen {

    public static void main(String[] args) throws Exception {
        Database database = new Database()
                .withName("org.jooq.meta.extensions.liquibase.LiquibaseDatabase")
                .withProperties(
                        new Property().withKey("rootPath").withValue("src/main/resources"),
                        new Property().withKey("scripts").withValue("db/changelog-master.yaml")
                );
        Generate options = new Generate()
                .withGeneratedAnnotation(true)
                .withGeneratedAnnotationDate(false)
                .withNullableAnnotation(true)
                .withNullableAnnotationType("org.jetbrains.annotations.Nullable")
                .withNonnullAnnotation(true)
                .withNonnullAnnotationType("org.jetbrains.annotations.NotNull")
                .withJpaAnnotations(false)
                .withValidationAnnotations(true)
                .withSpringAnnotations(true)
                .withConstructorPropertiesAnnotation(true)
                .withConstructorPropertiesAnnotationOnPojos(true)
                .withConstructorPropertiesAnnotationOnRecords(true)
                .withFluentSetters(false)
                .withDaos(false)
                .withPojos(true);

        Target target = new Target()
                .withPackageName("ru.viewvoyage.content_service.java.scrapper.domain.jooq")
                .withDirectory("scrapper/src/main/java");

        Configuration configuration = new Configuration()
                .withGenerator(
                        new Generator()
                                .withDatabase(database)
                                .withGenerate(options)
                                .withTarget(target)
                );

        GenerationTool.generate(configuration);
    }
}

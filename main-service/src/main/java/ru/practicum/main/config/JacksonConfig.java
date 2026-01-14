package ru.practicum.main.config;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static ru.practicum.main.config.Constant.FORMATTER;

@Configuration
public class JacksonConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> {
            builder.simpleDateFormat("yyyy-MM-dd HH:mm:ss");

            builder.serializers(new LocalDateSerializer(
                    java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd")));

            builder.serializers(new LocalDateTimeSerializer(FORMATTER));

            builder.deserializers(new LocalDateDeserializer(
                    java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd")));

            builder.deserializers(new LocalDateTimeDeserializer(FORMATTER));

            builder.featuresToDisable(com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        };
    }
}

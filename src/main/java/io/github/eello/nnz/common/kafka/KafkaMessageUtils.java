package io.github.eello.nnz.common.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class KafkaMessageUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String serialize(KafkaMessage<?> message) throws JsonProcessingException {
        return objectMapper.writeValueAsString(message);
    }

    public static <T> KafkaMessage<T> deserialize(String message, Class<T> genericType) throws JsonProcessingException {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(KafkaMessage.class, genericType);
        return objectMapper.readValue(message, javaType);
    }
}

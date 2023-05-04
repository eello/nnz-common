package io.github.eello.nnz.common.kafka;

public class KafkaMessage<T> {

    private KafkaMessageType type;
    private T body;

    public KafkaMessage(KafkaMessageType type) {
        this.type = type;
    }

    public static KafkaMessage create() {
        return new KafkaMessage(KafkaMessageType.CREATE);
    }

    public static KafkaMessage update() {
        return new KafkaMessage(KafkaMessageType.UPDATE);
    }

    public static KafkaMessage delete() {
        return new KafkaMessage(KafkaMessageType.DELETE);
    }

    public KafkaMessage<T> body(T body) {
        this.body = body;
        return this;
    }

    public enum KafkaMessageType {
        CREATE, UPDATE, DELETE,
        ;
    }
}

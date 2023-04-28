package za.co.simplifiedtech.kafka;

public enum KafkaEnum {
    COMMIT_INTERVAL("1000"),
    ACKS("all"),
    RETRIES("0"),
    LINGER_MS("1");

    private String value;

    KafkaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

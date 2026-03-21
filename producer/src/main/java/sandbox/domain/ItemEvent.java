package sandbox.domain;

public record ItemEvent(
        Integer id,
        EventType eventType,
        Item item

) {
}

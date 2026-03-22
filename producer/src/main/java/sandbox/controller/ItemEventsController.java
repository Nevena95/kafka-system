package sandbox.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sandbox.domain.ItemEvent;
import sandbox.producer.ItemEventsProducer;

@RestController
@Slf4j
public class ItemEventsController {

    private final ItemEventsProducer itemEventsProducer;

    public ItemEventsController(ItemEventsProducer itemEventsProducer) {
        this.itemEventsProducer = itemEventsProducer;
    }

    @PostMapping("/v1/itemevent")
    public ResponseEntity<ItemEvent> postItemEvent(@RequestBody ItemEvent itemEvent) throws JsonProcessingException {

        log.info("itemEvent: {}", itemEvent);
        // invoke the kafka producer
        itemEventsProducer.sendEvent(itemEvent);

        return ResponseEntity.status(HttpStatus.CREATED).body(itemEvent);
    }
}

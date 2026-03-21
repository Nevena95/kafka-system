package sandbox.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sandbox.domain.ItemEvent;

@RestController
@Slf4j
public class ItemEventsController {

    @PostMapping("/v1/itemevent")
    public ResponseEntity<ItemEvent> postItemEvent(@RequestBody ItemEvent itemEvent) {

        log.info("itemEvent: {}", itemEvent);
        // invoke the kafka producer

        return ResponseEntity.status(HttpStatus.CREATED).body(itemEvent);
    }
}

package dandannnnn.invite_api.web.rest;

import dandannnnn.invite_api.service.dto.GreetingDTO;
import dandannnnn.invite_api.service.GreetingService;
import dandannnnn.invite_api.service.dto.ResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.time.Month;
import java.util.Locale;


@RestController
@RequestMapping("/api/greetings")
@Slf4j
@RequiredArgsConstructor
public class GreetingResource {

    private static final String ENTITY_NAME = "Greeting";
    private final GreetingService greetingService;
    private final MessageSource messageSource;

    @GetMapping("/{month}/{day}")
    public ResponseDTO<GreetingDTO> view(@PathVariable Month month, @PathVariable int day) {
        log.debug("REST request to get greeting.");
        return ResponseDTO.data(greetingService.get(month, day));
    }

    @PostMapping
    public ResponseDTO<Long> create(@Valid @RequestBody GreetingDTO greetingDTO) {
        log.debug("REST request to create greeting: {}", greetingDTO);
        var saved = greetingService.create(greetingDTO);
        return ResponseDTO.data(saved.getId(), messageSource.getMessage("success.created", new Object[]{ENTITY_NAME}, Locale.getDefault()));
    }
}

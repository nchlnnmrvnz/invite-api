package dandannnnn.invite_api.web.rest;

import dandannnnn.invite_api.service.dto.GreetingDTO;
import dandannnnn.invite_api.service.GreetingService;
import dandannnnn.invite_api.service.dto.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/greetings")
@Slf4j
@RequiredArgsConstructor
public class GreetingResource {

    private final GreetingService greetingService;

    @GetMapping("/{filename}")
    public ResponseDTO<GreetingDTO> view(@PathVariable String filename) {
        log.debug("REST request to get greeting.");
        return ResponseDTO.data(greetingService.get(filename));
    }

}

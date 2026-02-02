package dandannnnn.invite_api.web.rest;

import dandannnnn.invite_api.service.ItineraryService;
import dandannnnn.invite_api.service.dto.ItineraryDTO;
import dandannnnn.invite_api.service.dto.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/itinerary")
@Slf4j
@RequiredArgsConstructor
public class ItineraryResource {

    private final ItineraryService itineraryService;

    @GetMapping("/{id}")
    public ResponseDTO<ItineraryDTO> view(@PathVariable Long id) {
        log.debug("REST request to get itinerary.");
        return ResponseDTO.data(itineraryService.get(id));
    }
}

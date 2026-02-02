package dandannnnn.invite_api.service;

import dandannnnn.invite_api.domain.Itinerary;
import dandannnnn.invite_api.repository.ItineraryRepository;
import dandannnnn.invite_api.service.dto.ItineraryDTO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class ItineraryService {
    private static final String ENTITY_NAME = "Itinerary";
    private static final String NOT_FOUND = " not found.";

    private final ItineraryRepository itineraryRepository;

    public ItineraryDTO get(Long id) {
        log.debug("Getting itinerary with id: {}", id);

        return itineraryRepository.findById(id)
            .map(this::toDTO)
            .orElseThrow(() -> new RuntimeException(ENTITY_NAME.concat(NOT_FOUND)));
    }

    private ItineraryDTO toDTO(Itinerary itinerary) {
        return ItineraryDTO.builder()
            .itineraryItemList(itinerary.getItineraryItemList())
            .build();
    }
}

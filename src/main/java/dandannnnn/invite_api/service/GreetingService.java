package dandannnnn.invite_api.service;

import dandannnnn.invite_api.domain.Greeting;
import dandannnnn.invite_api.repository.GreetingRepository;
import dandannnnn.invite_api.service.dto.GreetingDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class GreetingService {
    private static final String ENTITY_NAME = "Greetings";
    private static final String NOT_FOUND = " not found.";
    private static final String FILE_EXTENSION = ".txt";

    private final GreetingRepository greetingRepository;

    public Greeting create(GreetingDTO greetingDTO) {
        return greetingRepository.save(Greeting.builder()
            .password(greetingDTO.getPassword())
            .message(greetingDTO.getMessage())
            .filename(String.valueOf(greetingDTO.getDay()).concat(FILE_EXTENSION))
            .month(greetingDTO.getMonth())
            .day(greetingDTO.getDay())
            .build()
        );
    }

    public GreetingDTO get(String filename) {
        log.debug("Getting greeting with filename: {}", filename);
        var id = greetingRepository.findByFilename(filename);
        if (id == null) {
            return new GreetingDTO();
        }
        return toDTO(findById(id));
    }

    private Greeting findById(Long id) {
        return greetingRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(ENTITY_NAME + NOT_FOUND));
    }

    private GreetingDTO toDTO(Greeting greeting) {
        return GreetingDTO.builder()
            .message(greeting.getMessage())
            .month(greeting.getMonth())
            .day(greeting.getDay())
            .build();
    }
}
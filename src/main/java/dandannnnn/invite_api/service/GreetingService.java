package dandannnnn.invite_api.service;

import dandannnnn.invite_api.domain.Greeting;
import dandannnnn.invite_api.repository.GreetingRepository;
import dandannnnn.invite_api.service.dto.GreetingDTO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Month;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class GreetingService {
    private static final String ENTITY_NAME = "Greeting";
    private static final String NOT_FOUND = " not found.";

    private final GreetingRepository greetingRepository;

    public Greeting create(GreetingDTO greetingDTO) {
        return greetingRepository.save(Greeting.builder()
            .password(greetingDTO.getPassword())
            .message(greetingDTO.getMessage())
            .month(greetingDTO.getMonth())
            .day(greetingDTO.getDay())
            .build()
        );
    }

    public GreetingDTO get(Month month, int day) {
        log.debug("Getting greeting for {} {}", month, day);
        return greetingRepository.findByMonthAndDay(month, day)
            .map(this::toDTO)
            .orElseThrow(() -> new RuntimeException(ENTITY_NAME.concat(NOT_FOUND)));
    }

    private GreetingDTO toDTO(Greeting greeting) {
        return GreetingDTO.builder()
            .message(greeting.getMessage())
            .password(greeting.getPassword())
            .month(greeting.getMonth())
            .day(greeting.getDay())
            .build();
    }
}
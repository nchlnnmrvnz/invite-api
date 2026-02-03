package dandannnnn.invite_api.repository;

import dandannnnn.invite_api.domain.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.Optional;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long>, JpaSpecificationExecutor<Greeting> {
    Optional<Greeting> findByMonthAndDay(Month month, int day);
}
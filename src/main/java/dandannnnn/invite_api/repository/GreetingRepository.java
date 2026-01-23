package dandannnnn.invite_api.repository;

import dandannnnn.invite_api.domain.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long>, JpaSpecificationExecutor<Greeting> {
    Long findByFilename(String filename);
}
package dandannnnn.invite_api.repository;

import dandannnnn.invite_api.domain.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary, Long>, JpaSpecificationExecutor<Itinerary> {
}

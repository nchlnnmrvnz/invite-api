package dandannnnn.invite_api.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Month;
import java.util.List;

@Entity
@Table(name = "greeting")
@Getter
@Setter
@Builder
public class Itinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Month month;

    @Column(nullable = false)
    @Min(1)
    @Max(31)
    private int day;

    @JoinColumn(nullable = false)
    @ManyToOne
    private List<ItineraryItem> itineraryItemList;
}

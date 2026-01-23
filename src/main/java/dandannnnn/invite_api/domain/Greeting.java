package dandannnnn.invite_api.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Month;

@Entity
@Table(name = "greeting")
@Getter
@Setter
@Builder
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Month month;

    @Column(nullable = false)
    @Min(1)
    @Max(31)
    private int day;
}

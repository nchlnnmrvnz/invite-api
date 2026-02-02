package dandannnnn.invite_api.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Month;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GreetingDTO implements Serializable {

    private Long id;
    private String password;
    private String message;
    private Month month;
    private int day;
}

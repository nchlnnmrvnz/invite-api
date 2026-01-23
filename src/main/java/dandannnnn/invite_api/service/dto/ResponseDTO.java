package dandannnnn.invite_api.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO<T> {

    private T data;
    private String message;

    /**
     * Creates a standard API response containing only data.
     * <p>
     * Use this when returning a successful response to the UI
     * without any alert or informational message.
     *
     * @param data the response payload to be sent to the client
     * @param <T>  the type of the response payload
     * @return a {@link ResponseDTO} containing the provided data
     */
    public static <T> ResponseDTO<T> data(T data) {
        return ResponseDTO.<T>builder()
                .data(data)
                .build();
    }
}
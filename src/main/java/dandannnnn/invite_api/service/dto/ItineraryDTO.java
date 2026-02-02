package dandannnnn.invite_api.service.dto;

import dandannnnn.invite_api.domain.ItineraryItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItineraryDTO {
    private List<ItineraryItem> itineraryItemList;
}

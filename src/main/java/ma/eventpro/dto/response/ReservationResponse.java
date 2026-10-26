package ma.eventpro.dto.response;

import lombok.*;
import ma.eventpro.entity.enums.ReservationStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationResponse {
    private Long id ;
    private String reference;
    private Instant creationDate;
    private Instant expirationDate;
    private ReservationStatus status;
    private BigDecimal totalAmount;
    private List<LigneReservationResponse> lines;
}

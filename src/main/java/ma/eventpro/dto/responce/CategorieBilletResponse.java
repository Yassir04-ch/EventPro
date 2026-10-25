package ma.eventpro.dto.responce;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.eventpro.entity.Evenement;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategorieBilletResponse {
    private Long id;
    private String name;
    private BigDecimal prixUnitaire;
    private Integer quantiteTotale;
    private Integer quotaMaxParClient;
    private Integer placesReservees;
}
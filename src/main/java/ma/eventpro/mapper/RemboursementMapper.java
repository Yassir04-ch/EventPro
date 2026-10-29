package ma.eventpro.mapper;

import ma.eventpro.dto.response.RemboursementResponse;
import ma.eventpro.entity.Remboursement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface RemboursementMapper {

    @Mapping(source = "payment.id" , target = "paymentId")
    @Mapping(source = "payemnt.reservation.id" , target = "reservationId")
    RemboursementResponse toResponse(Remboursement remboursement);
}

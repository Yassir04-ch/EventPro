package ma.eventpro.mapper;

import ma.eventpro.dto.request.CategorieBilletRequest;
import ma.eventpro.dto.response.CategorieBilletResponse;
import ma.eventpro.entity.CategorieBillet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategorieBilletMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "evenement", ignore = true)
    @Mapping(target = "placesReservees", ignore = true)
    CategorieBillet toEntity(CategorieBilletRequest request);

    CategorieBilletResponse toResponse(CategorieBillet categorie);
}

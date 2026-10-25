package ma.eventpro.mapper;

import ma.eventpro.dto.request.EventCreateRequest;
import ma.eventpro.dto.response.EvenementResponse;
import ma.eventpro.entity.Evenement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EvenementMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "organisateur", ignore = true)
    @Mapping(target = "status", ignore = true)
    Evenement toEntity(EventCreateRequest request);

    @Mapping(source = "organisateur.id", target = "organisateurId")
    EvenementResponse toResponse(Evenement evenement);
}

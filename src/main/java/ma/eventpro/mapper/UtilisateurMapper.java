package ma.eventpro.mapper;

import ma.eventpro.dto.request.AdministrateurCreateRequest;
import ma.eventpro.dto.request.AgentControleCreateRequest;
import ma.eventpro.dto.request.ClientCreateRequest;
import ma.eventpro.dto.request.OrganisateurCreateRequest;
import ma.eventpro.entity.Administrateur;
import ma.eventpro.entity.AgentControle;
import ma.eventpro.entity.Client;
import ma.eventpro.entity.Organisateur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {
    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "reservations", ignore = true)
    Client toEntity(ClientCreateRequest request);

    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "evenements", ignore = true)
    Organisateur toEntity(OrganisateurCreateRequest request);

    @Mapping(target = "id" , ignore = true)
    Administrateur toEntity(AdministrateurCreateRequest request);

    @Mapping(target = "id" , ignore = true)
    AgentControle toEntity(AgentControleCreateRequest request);
}

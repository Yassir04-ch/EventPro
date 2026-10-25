
package ma.eventpro.mapper;

import ma.eventpro.dto.request.AdministrateurCreateRequest;
import ma.eventpro.dto.request.AgentControleCreateRequest;
import ma.eventpro.dto.request.ClientCreateRequest;
import ma.eventpro.dto.request.OrganisateurCreateRequest;
import ma.eventpro.dto.response.UtilisateurResponse;
import ma.eventpro.entity.Administrateur;
import ma.eventpro.entity.AgentControle;
import ma.eventpro.entity.Client;
import ma.eventpro.entity.Organisateur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phone", target = "telephone")
    Client toEntity(ClientCreateRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "evenements", ignore = true)
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "email", target = "email")
    Organisateur toEntity(OrganisateurCreateRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "email", target = "email")
    Administrateur toEntity(AdministrateurCreateRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "email", target = "email")
    AgentControle toEntity(AgentControleCreateRequest request);

    @Mapping(target = "role", constant = "CLIENT")
    @Mapping(source = "telephone", target = "phone")
    @Mapping(target = "organisationName", ignore = true)
    UtilisateurResponse toClientResponse(Client client);

    @Mapping(target = "role", constant = "ORGANISATEUR")
    @Mapping(source = "organisationName", target = "organisationName")
    @Mapping(target = "phone", ignore = true)
    UtilisateurResponse toOrganisateurResponse(Organisateur organisateur);

    @Mapping(target = "role", constant = "ADMINISTRATEUR")
    @Mapping(target = "phone", ignore = true)
    @Mapping(target = "organisationName", ignore = true)
    UtilisateurResponse toAdministrateurResponce(Administrateur administrateur);

    @Mapping(target = "role", constant = "AGENT_CONTROLE")
    @Mapping(target = "phone", ignore = true)
    @Mapping(target = "organisationName", ignore = true)
    UtilisateurResponse toAgentControleResponce(AgentControle agentControle);
}

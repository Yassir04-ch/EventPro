package ma.eventpro.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.eventpro.dto.request.AdministrateurCreateRequest;
import ma.eventpro.dto.request.AgentControleCreateRequest;
import ma.eventpro.dto.request.ClientCreateRequest;
import ma.eventpro.dto.request.OrganisateurCreateRequest;
import ma.eventpro.dto.responce.UtilisateurResponse;
import ma.eventpro.service.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @PostMapping("/clients")
    @ResponseStatus(HttpStatus.CREATED)
    public UtilisateurResponse createClient(@Valid @RequestBody ClientCreateRequest request) {
        return utilisateurService.createClient(request);
    }

    @PostMapping("/organisateurs")
    @ResponseStatus(HttpStatus.CREATED)
    public UtilisateurResponse createOrganisateur(@Valid @RequestBody OrganisateurCreateRequest request) {
        return utilisateurService.createOrganisateur(request);
    }

    @PostMapping("/admins")
    @ResponseStatus(HttpStatus.CREATED)
    public UtilisateurResponse createAdministrateur(@Valid @RequestBody AdministrateurCreateRequest request) {
        return utilisateurService.createAdministrateur(request);
    }

    @PostMapping("/agents")
    @ResponseStatus(HttpStatus.CREATED)
    public UtilisateurResponse createAgentControle(@Valid @RequestBody AgentControleCreateRequest request) {
        return utilisateurService.createAgentControle(request);
    }
}
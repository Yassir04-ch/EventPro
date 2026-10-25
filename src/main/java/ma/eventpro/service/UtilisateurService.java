package ma.eventpro.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ma.eventpro.dto.request.AdministrateurCreateRequest;
import ma.eventpro.dto.request.AgentControleCreateRequest;
import ma.eventpro.dto.request.ClientCreateRequest;
import ma.eventpro.dto.request.OrganisateurCreateRequest;
import ma.eventpro.dto.response.UtilisateurResponse;
import ma.eventpro.entity.Administrateur;
import ma.eventpro.entity.AgentControle;
import ma.eventpro.entity.Client;
import ma.eventpro.entity.Organisateur;
import ma.eventpro.exception.ConflictException;
import ma.eventpro.mapper.UtilisateurMapper;
import ma.eventpro.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UtilisateurService {
    private final UserRepository userRepository;
    private final UtilisateurMapper utilisateurMapper;

    private void checkEmailAvailable(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new ConflictException("Cet email est déja utilisé");
        }
    }

    @Transactional
    public UtilisateurResponse createClient(ClientCreateRequest request){
       checkEmailAvailable(request.getEmail());
       Client client =  userRepository.save(utilisateurMapper.toEntity(request));
        return utilisateurMapper.toClientResponse(client);
    }

    @Transactional
    public UtilisateurResponse createOrganisateur(OrganisateurCreateRequest request){
        checkEmailAvailable(request.getEmail());
        Organisateur organisateur = userRepository.save(utilisateurMapper.toEntity(request));
        return utilisateurMapper.toOrganisateurResponse(organisateur);
    }

    @Transactional
    public UtilisateurResponse createAdministrateur(AdministrateurCreateRequest request){
        checkEmailAvailable(request.getEmail());
        Administrateur administrateur = userRepository.save(utilisateurMapper.toEntity(request));
        return utilisateurMapper.toAdministrateurResponce(administrateur);
    }

    @Transactional
    public UtilisateurResponse createAgentControle(AgentControleCreateRequest request){
        checkEmailAvailable(request.getEmail());
        AgentControle agentControle = userRepository.save(utilisateurMapper.toEntity(request));
        return utilisateurMapper.toAgentControleResponce(agentControle);
    }

}

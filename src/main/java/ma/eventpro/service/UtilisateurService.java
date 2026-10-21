package ma.eventpro.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ma.eventpro.dto.request.ClientCreateRequest;
import ma.eventpro.dto.responce.UtilisateurResponse;
import ma.eventpro.entity.Client;
import ma.eventpro.exception.ConflictException;
import ma.eventpro.mapper.UtilisateurMapper;
import ma.eventpro.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UtilisateurService {
    private final UserRepository userRepository;
    private final UtilisateurMapper utilisateurMapper;

}

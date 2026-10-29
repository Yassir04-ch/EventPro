package ma.eventpro.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.eventpro.dto.request.PaiementCreateRequest;
import ma.eventpro.dto.response.PaiementResponse;
import ma.eventpro.service.PaiementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/paiements")
@RequiredArgsConstructor
public class PaiementController {

    private final PaiementService paiementService;

    @PostMapping
    public ResponseEntity<PaiementResponse> createPaiement(@Valid @RequestBody PaiementCreateRequest request){
        PaiementResponse response = paiementService.createPaiement(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

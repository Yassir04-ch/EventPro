package ma.eventpro.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.eventpro.dto.request.EventCreateRequest;
import ma.eventpro.dto.response.EvenementResponse;
import ma.eventpro.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@AllArgsConstructor
@Tag(name = "Evenements" ,description = "Gestion des evenements")
public class EventController {
    private final EventService eventService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EvenementResponse createEvent(@Valid @RequestBody EventCreateRequest request){
        return eventService.createEvent(request);
    }

    @PutMapping("/{id}/publish")
    public EvenementResponse publishEvent(@PathVariable Long id){
        return eventService.publishEvent(id);
    }

    @PutMapping("/{id}/cancel")
    public EvenementResponse cancelEvent(@PathVariable Long id){
        return eventService.cancelEvent(id);
    }

    @GetMapping("/{id}")
    public EvenementResponse getEvent(@PathVariable Long id){
        return eventService.getById(id);
    }

    @GetMapping
    public List<EvenementResponse> getPublishedEvents() {
        return eventService.getPublishedEvents();
    }
}

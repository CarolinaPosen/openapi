package by.mikhalevich.architecture.controller;

import by.mikhalevich.architecture.model.Aircraft;
import by.mikhalevich.architecture.repositories.AircraftCrudRepository;
import io.swagger.annotations.Api;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController()
@RequiredArgsConstructor
@RequestMapping(produces = "application/json")
@Api(value = "", tags = {"AircraftTag", "CustomDescription"})
@Tag(name="AircraftController", description="CRUD AIRCRAFT")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Another transaction deleted Aircraft."),
        @ApiResponse(responseCode = "201", description = "The Aircraft has been correctly deleted."),
        @ApiResponse(responseCode = "400", description = "The transaction schema is invalid."),
        @ApiResponse(responseCode = "415", description = "The content type is unsupported"),
        @ApiResponse(responseCode = "501", description = "An unexpected error has occurred.") })
public class AircraftController {

    private final AircraftCrudRepository repository;

    @GetMapping(path = "/api/aircrafts")
    public List<Aircraft> getAircrafts() {
        return repository.findAll();
    }


    @Operation(summary = "My endpoint",
               security = @SecurityRequirement(name = "basicAuth"))
    @GetMapping(path = "/api/aircrafts/{id}")
    public Aircraft getAircraft(@PathVariable
                                @Parameter(description = "Aircraft ID", required = true) long id) {
        return repository.findById(id).get();
    }

    @Operation(summary = "Short description", description = "Long description")
    @PostMapping(path = "/api/aircrafts")
    public ResponseEntity<Aircraft> createAircraft(@RequestBody @NotNull Aircraft aircraft) {
        Aircraft createAircraft = repository.save(aircraft);
        return ResponseEntity.ok(createAircraft);
    }

    @PutMapping(path = "/api/aircrafts")
    public ResponseEntity<Aircraft> updateAircraft(@RequestBody Aircraft aircraft) {
        Aircraft savedAircraft = repository.save(aircraft);
        return ResponseEntity.ok(savedAircraft);
    }

    @Hidden
    @Tag(name = "Hidden controller", description = "Delete aircraft")
    @DeleteMapping(path = "/api/aircrafts")
    public ResponseEntity<Aircraft> deleteGroup(@RequestBody @Valid Aircraft aircraft) {
        repository.delete(aircraft);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

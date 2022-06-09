package by.mikhalevich.architecture.repositories;

import by.mikhalevich.architecture.model.Aircraft;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AircraftCrudRepository extends CrudRepository<Aircraft, Long> {
List<Aircraft> findAll();
}

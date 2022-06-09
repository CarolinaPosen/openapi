package by.mikhalevich.architecture.repositories;

import by.mikhalevich.architecture.model.Aircraft;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightCrudRepository extends CrudRepository<Aircraft, String> {
}

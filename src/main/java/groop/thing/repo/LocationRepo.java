package groop.thing.repo;

import groop.thing.entity.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepo extends CrudRepository<Location,Integer> {
}

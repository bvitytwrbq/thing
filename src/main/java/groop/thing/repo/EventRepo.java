package groop.thing.repo;

import groop.thing.entity.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepo extends CrudRepository<Event,Integer> {
}

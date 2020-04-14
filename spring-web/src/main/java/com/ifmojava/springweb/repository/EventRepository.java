package com.ifmojava.springweb.repository;

import com.ifmojava.springweb.entity.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository
        extends CrudRepository<Event, Integer> {
}

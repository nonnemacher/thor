package br.com.thor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Carlos H. Nonnemacher
 */
@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @RequestMapping(method = GET)
    Iterable<Event> findAll() {
        return eventRepository.findAll();
    }

    @RequestMapping(method = POST)
    Event save(@RequestBody Event event) {
        return eventRepository.save(event);
    }

    @RequestMapping(value = "/{id}", method = GET)
    Event findOne(@PathVariable Long id) {
        return eventRepository.findOne(id);
    }
}

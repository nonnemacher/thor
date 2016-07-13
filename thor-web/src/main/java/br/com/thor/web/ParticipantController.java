package br.com.thor.web;

import java.util.ArrayList;
import java.util.List;
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
@RequestMapping("/participant")
public class ParticipantController {

    @Autowired
    ParticipantRepository participantRepository;

    @RequestMapping(method = GET)
    Iterable<Participant> findAll() {
        return participantRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = GET)
    Participant findOne(@PathVariable Long id) {
        return participantRepository.findOne(id);
    }

    @RequestMapping(method = POST)
    List<Participant> save(@RequestBody List<Participant> participants) {
        List<Participant> participants1 = new ArrayList<>();
        participants.forEach((p) -> {
            Participant participant;
            participant = participantRepository.findOneByEmail(p.getEmail());
            if (participant == null) {
                participant = participantRepository.save(p);
            }
            participants1.add(participant);
        });
        return participants1;
    }

}

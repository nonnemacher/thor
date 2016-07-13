package br.com.thor.web;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Carlos H. Nonnemacher
 */
public interface ParticipantRepository extends PagingAndSortingRepository<Participant, Long>{
    
    Participant findOneByEmail(String email);
        
}

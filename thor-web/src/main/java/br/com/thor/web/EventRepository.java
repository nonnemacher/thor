package br.com.thor.web;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Carlos H. Nonnemacher
 */
public interface EventRepository extends PagingAndSortingRepository<Event, Long>{
    
}

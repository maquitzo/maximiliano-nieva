package ar.com.inna.xcale.challenge.repository;

import ar.com.inna.xcale.challenge.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactRepository extends CrudRepository<Contact, Long> {

}

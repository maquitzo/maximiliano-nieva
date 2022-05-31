package ar.com.inna.xcale.challenge.repository;

import ar.com.inna.xcale.challenge.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface IMessageRepository extends CrudRepository<Message, Long> {
}

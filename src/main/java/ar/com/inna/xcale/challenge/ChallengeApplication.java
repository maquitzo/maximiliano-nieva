package ar.com.inna.xcale.challenge;

import ar.com.inna.xcale.challenge.model.Contact;
import ar.com.inna.xcale.challenge.model.Room;
import ar.com.inna.xcale.challenge.repository.IContactRepository;
import ar.com.inna.xcale.challenge.repository.IRoomRepository;
import ar.com.inna.xcale.challenge.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ChallengeApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(ChallengeApplication.class);

	@Autowired
	private IContactRepository iContactRepository;

	@Autowired
	private IRoomRepository iRoomRepository;

	@Autowired
	private MessageService messageService;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) {

		try {

			log.info("creating contacts");
			Contact c1 = new Contact("1150006666");
			Contact c2 = new Contact("1160008888");
			Contact c3 = new Contact("1170001111");
			this.iContactRepository.save(c1);
			this.iContactRepository.save(c2);
			this.iContactRepository.save(c3);

			log.info("creating rooms");
			Room r1 = new Room("Roomies");
			r1.setContact(new ArrayList() {{ add(c1); add(c2); }});
			this.iRoomRepository.save(r1);

			log.info("sending messages");
			messageService.SendMessage(r1,c1,"Buen dia Grupo !");
			messageService.SendMessage(r1,c3,"Hola ");

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}

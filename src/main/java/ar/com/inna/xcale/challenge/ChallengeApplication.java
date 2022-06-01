package ar.com.inna.xcale.challenge;

import ar.com.inna.xcale.challenge.model.Contact;
import ar.com.inna.xcale.challenge.model.Room;
import ar.com.inna.xcale.challenge.repository.IContactRepository;
import ar.com.inna.xcale.challenge.repository.IRoomRepository;
import ar.com.inna.xcale.challenge.service.ContactService;
import ar.com.inna.xcale.challenge.service.MessageService;
import ar.com.inna.xcale.challenge.service.RoomService;
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
	private MessageService messageService;

	@Autowired
	private ContactService contactService;

	@Autowired
	private RoomService roomService;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) {

		try {

			log.info("creating contacts");
			Contact c1 = contactService.Setup("1150006666");
			Contact c2 = contactService.Setup("1160008888");
			Contact c3 = contactService.Setup("1170001111");
			Contact c4 = contactService.Setup("1190004444");

			log.info("creating rooms");
			List<Long> roomContacts = new ArrayList<>();
			roomContacts.add(c1.getId());
			roomContacts.add(c2.getId());
			roomContacts.add(c3.getId());
			Room r1 = roomService.Setup("Roomies", roomContacts);

			log.info("sending messages");
			messageService.SendMessage(r1,c1,"Buen dia Grupo !");
			messageService.SendMessage(r1,c4,"Hola ");

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}

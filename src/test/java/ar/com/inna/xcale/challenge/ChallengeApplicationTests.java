package ar.com.inna.xcale.challenge;

import ar.com.inna.xcale.challenge.model.Contact;
import ar.com.inna.xcale.challenge.model.Room;
import ar.com.inna.xcale.challenge.repository.IRoomRepository;
import ar.com.inna.xcale.challenge.service.MessageService;
import ar.com.inna.xcale.challenge.service.RoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.Before;
//import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ChallengeApplicationTests {

	@Autowired
	private IRoomRepository iRoomRepository;

	@Autowired
	private RoomService roomService;


	@Test
	void contextLoads() {
	}

	@Test
	public void addingContactShouldAddOneToList() {

		Room room = roomService.Setup("Test", new ArrayList<>());

		int quantityOfContacts = room.getContact().size();

		List<Contact> roomContacts = new ArrayList<>();
		roomContacts.add(new Contact("11114444"));
		room.setContact(roomContacts);
		this.iRoomRepository.save(room);

		assertEquals(quantityOfContacts + 1, room.getContact().size());
	}

	@Test
	public void removeContactListedCorrectly() {

		Room room = new Room("Test");
		List<Contact> roomContacts = new ArrayList<>();
		roomContacts.add(new Contact("22224444"));
		roomContacts.add(new Contact("33334444"));
		roomContacts.add(new Contact("88884444"));
		room.setContact(roomContacts);
		this.iRoomRepository.save(room);

		int quantityOfContacts = room.getContact().size();

		Room roomValid = this.iRoomRepository.findById(room.getId()).get();
		List<Contact> removeContacts = roomValid.getContact();
		removeContacts.remove(0);
		roomValid.setContact(removeContacts);
		this.iRoomRepository.save(roomValid);

		assertEquals(quantityOfContacts -1 , roomValid.getContact().size()  );
	}

}

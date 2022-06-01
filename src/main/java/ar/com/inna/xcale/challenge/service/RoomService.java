package ar.com.inna.xcale.challenge.service;

import ar.com.inna.xcale.challenge.model.Contact;
import ar.com.inna.xcale.challenge.model.Room;
import ar.com.inna.xcale.challenge.repository.IContactRepository;
import ar.com.inna.xcale.challenge.repository.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RoomService {
    @Autowired
    private IRoomRepository iRoomRepository;

    @Autowired
    private IContactRepository iContactRepository;

    public Room Setup(String name, List<Long> contacts) {

        List<Contact> roomContacts = new ArrayList<>();
        for(Long c: contacts)
            roomContacts.add(iContactRepository.findById(c).orElse(null));

        Room room = new Room(name);
        room.setContact(roomContacts);

        return this.iRoomRepository.save(room);

    }


}

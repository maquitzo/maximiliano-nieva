package ar.com.inna.xcale.challenge.service;

import ar.com.inna.xcale.challenge.model.Contact;
import ar.com.inna.xcale.challenge.model.Message;
import ar.com.inna.xcale.challenge.model.Room;
import ar.com.inna.xcale.challenge.repository.IMessageRepository;
import ar.com.inna.xcale.challenge.repository.IRoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class MessageService {

    private static final Logger log = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    private IRoomRepository iRoomRepository;

    @Autowired
    private IMessageRepository iMessageRepository;

    public void SendMessage(Room room, Contact contact, String text) throws Exception {

        log.info("validate room");
        Optional<Room> room_filter = iRoomRepository
                .findById(room.getId())
                .stream()
                .findFirst();

        if (!room_filter.isPresent())
            throw new Exception("Room is not available");

        log.info("validate relation with contact");
        Optional<Contact> contact_filter = room_filter.get().getContact()
                .stream()
                .filter(con->con.getId().equals(contact.getId()))
                .findFirst();

        if (!contact_filter.isPresent())
            throw new Exception("Contact doesn't belong to this group");

        log.info("persistence");
        Message message = new Message();
        message.setFrom(contact);
        message.setRoom(room);
        message.setMessage(text);
        iMessageRepository.save(message);

        log.info("console output");
        System.out.println(String.format("[%s-%s] ha enviado : %s", room.getName(), contact.getPhoneNumber(), text));
    }

}

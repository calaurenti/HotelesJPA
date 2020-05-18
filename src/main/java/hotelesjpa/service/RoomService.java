package hotelesjpa.service;

import hotelesjpa.entity.Room;
import hotelesjpa.repository.HotelName;
import hotelesjpa.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Iterable<Room> findAll(){ return roomRepository.findAll(); }

    public Optional<Room> findByName(String name){
        return roomRepository.findByNameCustom(name);
    }

}

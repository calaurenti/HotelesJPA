package hotelesjpa.repository;

import hotelesjpa.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

    public Optional<Room> findByNameCustom(String name);

}

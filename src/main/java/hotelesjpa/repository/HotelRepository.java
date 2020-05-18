package hotelesjpa.repository;

import hotelesjpa.entity.Hotel;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    //public List<Hotel> findAll();

    public Optional<Hotel> findById(Long id);

    public Set<Hotel> findAllByCityId(String cityId);

    public Set<Hotel> findAllByCityIdCustom(String cityId);

    //@Query("select h from Hotel h where h.name = ?1")
    @Query(value = "select * from BO_HOTEL where NAME = ?1", nativeQuery = true)
    public Optional<Hotel> findByName(String name);

    public List<HotelName> findByCityId(String cityId);

    //Limited
    Hotel findTopByOrderByNameDesc();

    @Query("select h from Hotel h")
    public Stream<SecurityProperties.User> streamAllPaged(Pageable pageable);

    public void deleteById(Long id);

}

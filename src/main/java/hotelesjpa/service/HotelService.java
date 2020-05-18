package hotelesjpa.service;

import hotelesjpa.entity.Hotel;
import hotelesjpa.repository.HotelName;
import hotelesjpa.repository.HotelRepository;
import org.springframework.data.domain.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;

    public Optional<Hotel> findById(Long id){
        return hotelRepository.findById(id);
    }

    public List<Hotel> findAll() { return hotelRepository.findAll();}

    //Sorted
    public List<Hotel> findAllSorted() { return hotelRepository.findAll(Sort.by("name"));}

    public Set<Hotel> findAllByCityId(String cityId) {return hotelRepository.findAllByCityId(cityId);}

    public Set<Hotel>findAllByCityIdCustom(String cityId) {return hotelRepository.findAllByCityIdCustom(cityId);}

    public Optional findByName(String name){return hotelRepository.findByName(name);}

    public List<HotelName> findAllHotelNamesByCityId(String cityId){ return hotelRepository.findByCityId(cityId);}

    //Query By Example
    public List<Hotel> findAll(Hotel hotel){return hotelRepository.findAll(Example.of(hotel));}

    public void save(Hotel hotel){hotelRepository.save(hotel);}

    //paginated
    public void streamAllPaged(int pageNumber, int position){
        Pageable page = PageRequest.of(pageNumber, position);
    }

    


}

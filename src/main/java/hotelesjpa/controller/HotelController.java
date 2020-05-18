package hotelesjpa.controller;

import hotelesjpa.entity.Hotel;
import hotelesjpa.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public class HotelController {

    @Autowired
    HotelService hotelService;

    //@GetMapping("/hotels")
    //public Iterable<Hotel> all() {
       // return HotelService.findAll();
    //}

    @GetMapping("/Hotel/{id}")
    public Optional<Hotel> getMovie(@PathVariable Long id){
        return hotelService.findById(id);
    }

    //@GetMapping("/movies/search")
    //public List<Movie> findAllByTitle(@RequestParam("title") String title){
    //    return  movieService.findAllByTitle(title);
    //}
}

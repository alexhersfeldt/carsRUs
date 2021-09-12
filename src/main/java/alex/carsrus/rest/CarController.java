package alex.carsrus.rest;


import alex.carsrus.entity.Car;
import alex.carsrus.repo.CarRepo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/cars", produces = MediaType.APPLICATION_JSON_VALUE)

public class CarController {

    private CarRepo repo;

    public CarController(CarRepo repo) {
        this.repo = repo;
    }


    @GetMapping
    Iterable<Car> findAllCars() {return repo.findAll();}

    @GetMapping(value = "/{id}")
    Car getCar(@PathVariable int id) {
        return repo.findById(id).orElseThrow();
    }

    @GetMapping(value ="/{brand}")
   Iterable<Car> findAllByBrand(@PathVariable String brand) {return repo.findAllByBrand(brand);}





}

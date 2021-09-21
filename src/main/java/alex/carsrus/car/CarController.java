package alex.carsrus.car;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/cars", produces = MediaType.APPLICATION_JSON_VALUE)

public class CarController {

    CarService service;

    public CarController(CarService service) {
        this.service = service;
    }


    @GetMapping("/{id}")
    CarDTO findCarById(@PathVariable int id) {
        return service.getCar(id);
    }

    @GetMapping
    Iterable<CarDTO> findAllCars() {
        return service.getCars(null, null);
    }

    @GetMapping
    Iterable<CarDTO> findCarsByBrand(String brand) {
        return service.getCars(brand, null);
    }

    @GetMapping
    Iterable<CarDTO> findCarsByBrandAndModel(String brand, String model) {
        return service.getCars(brand, model);
    }

    @GetMapping
    Iterable<CarDTO> findCarsByPricePerDayLessThan(int price) {return service.getCarsByPricePerDayLessThan(price);}

    @GetMapping
    Iterable<CarDTO> findCarsByPricePerDayLessThanEquals(int price) {return service.getCarsByPricePerDayLessThanEquals(price);}

    @PostMapping
    CarDTO addCar(@RequestBody CarDTO newCar) {return service.addCar(newCar);
    }

    @PutMapping("/{id}")
    CarDTO editCar(@RequestBody CarDTO car, @PathVariable int id) throws Exception {
        return service.editCar(car, id);
    }

    @DeleteMapping("/{id}")
    void deleteCar(@PathVariable int id) {service.deleteCar(id);}

}

package alex.carsrus.car;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/cars")

public class CarController {

    CarService service;

    public CarController(CarService service) {
        this.service = service;
    }


    @GetMapping("/{id}")
    CarDTO getCarById(@PathVariable int id) {
        return service.getCar(id);
    }

    @GetMapping
    Iterable<CarDTO> getCars(@RequestParam(required = false) String brand, @RequestParam(required = false) String model) {
        if(brand == null && model != null){
            //We will eventually handle this better
            throw new IllegalArgumentException("Brand required when model is supplied");
        }
        return service.getCars(brand,model);
    }

    @PostMapping
    CarDTO addCar(@RequestBody CarDTO newCar) {return service.addCar(newCar);
    }

    @PutMapping("/{id}")
    CarDTO editCar(@RequestBody CarDTO car, @PathVariable int id) {
        return service.editCar(car, id);
    }

    @DeleteMapping("/{id}")
    void deleteCar(@PathVariable int id) {service.deleteCar(id);}

}

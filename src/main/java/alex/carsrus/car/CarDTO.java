package alex.carsrus.car;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDTO {

    int id;
    String brand;
    String model;
    int pricePerDay;


    public CarDTO(String brand, String model, int pricePerDay) {
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
    }

    public CarDTO(Car car) {
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.pricePerDay = car.getPricePerDay();
        this.id = car.getCarId();
    }

    public static List<CarDTO> carDTOSFromCar(Iterable<Car> cars){
        List<CarDTO> carDTOs = new ArrayList<>();
        for(Car car : cars){
            CarDTO aCar = new CarDTO(car);
            carDTOs.add(aCar);
        }
        return carDTOs;
    }

    public static Car carFromCarDTO(CarDTO car){
        return new Car(car.getBrand(),car.getModel(), car.getPricePerDay());
    }
}

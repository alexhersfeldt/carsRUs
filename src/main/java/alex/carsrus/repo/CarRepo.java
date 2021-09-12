package alex.carsrus.repo;

import alex.carsrus.entity.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepo extends CrudRepository<Car, Integer> {

    Iterable<Car> findAllByBrand(String brand);
    Iterable<Car> findByBrandAndModel(String brand, String model);
    Iterable<Car> findByPricePrDayLessThan(int price);
}

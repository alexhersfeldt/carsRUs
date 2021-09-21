package alex.carsrus.car;

import org.springframework.data.repository.CrudRepository;

public interface CarRepo extends CrudRepository<Car,Integer> {
    Iterable<Car> findCarsByBrand(String brand);
    Iterable<Car> findCarsByBrandAndModel(String brand, String model);
    Iterable<Car> findCarsByPricePerDayLessThan(double pricePrDay);
    Iterable<Car> findCarsByPricePerDayLessThanEqual(double pricePrDay);
}
package alex.carsrus.config;

import alex.carsrus.car.Car;
import alex.carsrus.car.CarRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSetup implements CommandLineRunner {
    private final CarRepo repo;

    public DataSetup(CarRepo repo) {
        this.repo = repo;
    }
    @Override
    public void run(String... args) throws Exception {
        repo.deleteAll();
        repo.save(new Car("Ford", "Model T", 12 ));
        repo.save(new Car("Ford", "F350", 40 ));
        repo.save(new Car("Saab", "Red Junk", 5 ));
        repo.save(new Car("Tesla", "T Truck", 50 ));
        repo.save(new Car("Tesla", "El Bil", 20 ));
        repo.save(new Car("Bike", "Race Bike", 5 ));
    }
}

package alex.carsrus.car;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    CarRepo carRepo;

    public CarService(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public CarDTO getCar(int id) {
        Car car = carRepo.findById(id).orElseThrow();
        return new CarDTO(car);
    }

    public List<CarDTO> getCars(String brand, String model) {
        if(brand!=null && model!=null ){
            return CarDTO.carDTOSFromCar(carRepo.findCarsByBrandAndModel(brand,model));
        }
        if(brand != null){
            return CarDTO.carDTOSFromCar(carRepo.findCarsByBrand(brand));
        }
        return CarDTO.carDTOSFromCar(carRepo.findAll());
    }

    public Iterable<CarDTO> getCarsByPricePerDayLessThan(int price) {
        return CarDTO.carDTOSFromCar(carRepo.findCarsByPricePerDayLessThan(price));
    }

    public Iterable<CarDTO> getCarsByPricePerDayLessThanEquals(int price) {
        return CarDTO.carDTOSFromCar(carRepo.findCarsByPricePerDayLessThanEqual(price));
    }
    

    public CarDTO addCar(CarDTO newCar){
        Car carToMake = CarDTO.carFromCarDTO(newCar);
        return new CarDTO(carRepo.save(carToMake));
    }

    public CarDTO editCar(CarDTO carToEdit, int id){
        Car carOrg = carRepo.findById(id).orElseThrow();
        carOrg.setBrand(carToEdit.getBrand());
        carOrg.setModel(carToEdit.getModel());
        carOrg.setPricePerDay(carToEdit.getPricePerDay());
        return new CarDTO(carRepo.save(carOrg));
    }

    public void deleteCar(int id) {
        carRepo.deleteById(id);
    }


}

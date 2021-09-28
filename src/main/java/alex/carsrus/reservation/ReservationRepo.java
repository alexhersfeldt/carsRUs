package alex.carsrus.reservation;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface ReservationRepo extends CrudRepository<Reservation,Integer> {
    Reservation findReservationByCar_CarIdAndRentalDate(int carId, LocalDate date);
}
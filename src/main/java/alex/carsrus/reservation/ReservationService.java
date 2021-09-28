package alex.carsrus.reservation;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReservationService {
    ReservationRepo reservationRepo;

    public ReservationService(ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    public boolean isCarFree(int carId, LocalDate date){
        Reservation res =  reservationRepo.findReservationByCar_CarIdAndRentalDate(carId,date);
        return res == null;
    }
}

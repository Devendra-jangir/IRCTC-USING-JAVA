package demo.irctc.services;

import demo.irctc.models.Booking;
import demo.irctc.models.Train;
import demo.irctc.models.User;
import demo.irctc.repositories.BookingRepository;
import demo.irctc.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TrainRepository trainRepository;

    @Transactional
    public boolean bookSeat(Long trainId, User user) {
        Train train = trainRepository.findById(trainId).orElse(null);
        if (train != null && train.getAvailableSeats() > 0) {
            train.setAvailableSeats(train.getAvailableSeats() - 1);
            trainRepository.save(train);

            Booking booking = new Booking();
            booking.setUser(user);
            booking.setTrain(train);
            booking.setStatus("CONFIRMED");
            bookingRepository.save(booking);

            return true;
        }
        return false;
    }
}


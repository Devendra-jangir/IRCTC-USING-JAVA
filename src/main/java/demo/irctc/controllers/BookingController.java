package demo.irctc.controllers;

import demo.irctc.models.User;
import demo.irctc.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<String> bookSeat(@RequestParam Long trainId, @RequestBody User user) {
        boolean success = bookingService.bookSeat(trainId, user);
        if (success) {
            return ResponseEntity.ok("Seat booked successfully!");
        }
        return ResponseEntity.status(409).body("Failed to book seat");
    }
}


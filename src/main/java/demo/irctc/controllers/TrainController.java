package demo.irctc.controllers;

import demo.irctc.models.Train;
import demo.irctc.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trains")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @PostMapping("/add")
    public ResponseEntity<String> addTrain(@RequestBody Train train) {
        trainService.addTrain(train);
        return ResponseEntity.ok("Train added successfully!");
    }

    @GetMapping("/availability")
    public ResponseEntity<List<Train>> getAvailability(@RequestParam String source, @RequestParam String destination) {
        return ResponseEntity.ok(trainService.getAvailability(source, destination));
    }
}

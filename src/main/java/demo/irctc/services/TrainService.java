package demo.irctc.services;

import demo.irctc.models.Train;
import demo.irctc.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    public void addTrain(Train train) {
        trainRepository.save(train);
    }

    public List<Train> getAvailability(String source, String destination) {
        return trainRepository.findBySourceAndDestination(source, destination);
    }
}


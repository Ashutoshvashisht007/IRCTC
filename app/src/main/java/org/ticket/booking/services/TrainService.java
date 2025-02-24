package org.ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ticket.booking.entities.Train;
import org.ticket.booking.entities.User;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class TrainService {
    private List<Train> trainList;
    private ObjectMapper objectMapper = new ObjectMapper(); // to serialize or deserialize
    private static final String TRAIN_PATH = "app/src/main/java/org/ticket/booking/localDB/trains.json";

    public TrainService() throws IOException{
        loadTrains();
    }

    public void loadTrains() throws IOException {
        File trains = new File(TRAIN_PATH);
        trainList = objectMapper.readValue(trains, new TypeReference<List<Train>>() {}); // to deserialzie generics on the runtime we use TypeReference.
    }

    public List<Train> searchTrains(String src, String dest){
        return trainList.stream().filter(train -> validTrain(train,src,dest)).collect(Collectors.toList());
    }

    public boolean validTrain(Train train,String src,String dest){
        List<String> stationOrder = train.getStations();

        int srcIdx = stationOrder.indexOf(src.toLowerCase());
        int destIdx = stationOrder.indexOf(dest.toLowerCase());

        return srcIdx != -1 && destIdx != -1 && srcIdx < destIdx;
    }

}

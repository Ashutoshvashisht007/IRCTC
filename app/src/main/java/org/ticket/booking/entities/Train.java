package org.ticket.booking.entities;

import java.sql.Time;
import java.util.List;
import java.util.Map;

public class Train {
    private String trainId;
    private String trainNum;
    private List<List<Integer>> seats;
    private Map<String, String> stationTimes;
    private List<String> stations;

    public Train(String trainId,String trainNum,List<List<Integer>> seats,Map<String,String> stationTimes,List<String> stations){
        this.trainId = trainId;
        this.trainNum = trainNum;
        this.seats = seats;
        this.stationTimes = stationTimes;
        this.stations = stations;
    }

    public String getTrainId(){
        return  trainId;
    }

    public String getTrainNum(){
        return trainNum;
    }

    public List<List<Integer>> getSeats(){
        return seats;
    }

    public Map<String,String> getStationTimes(){
        return stationTimes;
    }

    public List<String> getStations(){
        return stations;
    }

    public void setTrainId(String trainId){
        this.trainId = trainId;
    }

    public void setTrainNum(String trainNum){
        this.trainNum = trainNum;
    }

    public void setSeats(List<List<Integer>> seats){
        this.seats = seats;
    }

    public void setStationTimes(Map<String,String> stationTimes){
        this.stationTimes = stationTimes;
    }

    public void setStations(List<String> stations){
        this.stations = stations;
    }

    public String getTrainInfo(){
        return String.format("Train ID: %s Train No: %s", trainId, trainNum);
    }

}

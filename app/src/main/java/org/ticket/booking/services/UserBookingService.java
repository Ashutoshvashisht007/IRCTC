package org.ticket.booking.services;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ticket.booking.entities.Ticket;
import org.ticket.booking.entities.User;
import org.ticket.booking.utils.UserServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserBookingService {

    private User user;
    private List<User> userList;

    private ObjectMapper objectMapper = new ObjectMapper(); // to serialize or deserialize
    private static final String USER_PATH = "app/src/main/java/org/ticket/booking/localDB/users.json";

    public UserBookingService(User user) throws IOException {
        this.user = user;
        File users = new File(USER_PATH);
        userList = objectMapper.readValue(users, new TypeReference<List<User>>() {}); // to deserialzie generics on the runtime we use TypeReference.
    }

    public Boolean loginUser(){
        Optional<User> foundUser = userList.stream().filter(user1 -> {
            return user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), user1.getHashPassword());
        }).findFirst();

        return foundUser.isPresent();
    }

    public Boolean signUp(User user1){
        try{
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        }catch (IOException e){
            return Boolean.FALSE;
        }
    }

    private void saveUserListToFile() throws  IOException{
        File usersFile = new File(USER_PATH);
        objectMapper.writeValue(usersFile,userList);
    }

    public void fetchBooking(){
        Optional<User> userFetched = userList.stream().filter(user1 -> {
            return user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), user1.getHashPassword());
        }).findFirst();
        userFetched.ifPresent(User::printTickets);
    }

    public boolean cancelBooking(String ticketId){

        if(ticketId == null || ticketId.isEmpty()){
            System.out.println("TicketId cannot be null or empty");
            return Boolean.FALSE;
        }

        String finalTicketId = ticketId;

        boolean removed = user.getTicketBooked().removeIf(ticket -> ticket.getTicketId().equals(finalTicketId));

        if(removed){
            System.out.println("Ticket with id" + ticketId + " has been canceled successfully");
            return Boolean.TRUE;
        }

        System.out.println("No ticket found with id " + ticketId);
        return Boolean.FALSE;
    }
}

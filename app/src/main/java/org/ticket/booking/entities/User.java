package org.ticket.booking.entities;

import java.util.List;

public class User {
    private String name;
    private String password;
    private  String hashPassword;
    private List<Ticket> ticketBooked;
    private  String userId;

    public User(String name,String password, String hashPassword,List<Ticket> ticketBooked,String userId){
        this.name = name;
        this.password = password;
        this.hashPassword = hashPassword;
        this.ticketBooked = ticketBooked;
        this.userId = userId;
    }

    public void printTickets(){
        for (Ticket ticket : ticketBooked) {
            System.out.println(ticket.getTicketInfo());
        }
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return  password;
    }

    public String getHashPassword(){
        return hashPassword;
    }

    public List<Ticket> getTicketBooked(){
        return ticketBooked;
    }

    public String getUserId(){
        return userId;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setHashPassword(String hashPassword){
        this.hashPassword = hashPassword;
    }

    public void  setUserId(String userId){
        this.userId = userId;
    }

    public void setTicketBooked(List<Ticket> ticketBooked){
        this.ticketBooked = ticketBooked;
    }
}

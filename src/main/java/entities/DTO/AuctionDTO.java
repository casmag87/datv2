package entities.DTO;

import entities.Auction;
import entities.Boat;

import java.util.ArrayList;
import java.util.List;

public class AuctionDTO {

    private Long id;
    private String name;
    private String date;
    private String time;
    private String location;
    private List<BoatDTO> boatList;

    public AuctionDTO() {
    }



    public AuctionDTO(String name, String date, String time, String location) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public AuctionDTO(Auction auction, List<Boat> boatList ) {
        this.name = auction.getName();
        this.date = auction.getDate();
        this.time = auction.getTime();
        this.location = auction.getLocation();

    }

    public AuctionDTO(Auction auction) {
        this.name = auction.getName();
        this.date = auction.getDate();
        this.time = auction.getTime();
        this.location = auction.getLocation();
    }

    public AuctionDTO(Long id, String name, String date, String time, String location) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<BoatDTO> getBoatList() {
        return boatList;
    }

    public void setBoatList(List<BoatDTO> boatList) {
        this.boatList = boatList;
    }
}

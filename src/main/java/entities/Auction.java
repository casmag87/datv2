package entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import entities.DTO.AuctionDTO;
import entities.DTO.BoatDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "auction")
public class Auction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Auction_name", length=15, nullable = false,unique = false )
    private String name;

    @Column(name="Auction_date", length=15, nullable = false,unique = false )
    private String date;

    @Column(name="Auction_time", length=15, nullable = false,unique = false )
    private String time;

    @Column(name="Auction_location", length=15, nullable = false,unique = false )
    private String location;


    @OneToMany(mappedBy = "auction", cascade = CascadeType.ALL)
    private List<Boat> boatList;



    public Auction() {
    }

    public Auction(String name, String date, String time, String location) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public Auction(AuctionDTO auctionDTO) {
        this.name = auctionDTO.getName();
        this.date = auctionDTO.getDate();
        this.time = auctionDTO.getTime();
        this.location = auctionDTO.getLocation();

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
}

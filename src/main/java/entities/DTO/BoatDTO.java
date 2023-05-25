package entities.DTO;

import entities.Boat;

import java.util.List;

public class BoatDTO {

    private Long id;
    private String name;
    private String brand;
    private String make;
    private String year;
    private String imageUrl;
    private AuctionDTO auctionDTO;
    private List<UserDTO> userList;

    public BoatDTO() {
    }

    public BoatDTO(Long id, String name, String brand, String make, String year, String imageUrl) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.make = make;
        this.year = year;
        this.imageUrl = imageUrl;
    }

    public BoatDTO(Boat boat) {
        if(boat.getId() != null){
            this.id = boat.getId();
        }
        this.name = boat.getName();
        this.brand = boat.getBrand();
        this.make = boat.getMake();
        this.year = boat.getYear();
        this.imageUrl = boat.getImageUrl();

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public AuctionDTO getAuctionDTO() {
        return auctionDTO;
    }

    public void setAuctionDTO(AuctionDTO auctionDTO) {
        this.auctionDTO = auctionDTO;
    }

    public List<UserDTO> getUserList() {
        return userList;
    }

    public void setUserList(List<UserDTO> userList) {
        this.userList = userList;
    }

    public String getMake() {return make;}

    public void setMake(String make) {this.make = make;}
}

package entities;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity(name = "boat")
public class Boat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="boat_name", length=20, nullable = false,unique = false )
    private String name;

    @Column(name="boat_brand", length=20, nullable = false,unique = false )
    private String brand;

    @Column(name = "boat_make",length=20, nullable = false,unique = false)
    private String make;

    @Column(name="boat_year", length=8, nullable = false,unique = false )
    private String year;

    @Column(name="boat_imageurl", length=50, nullable = false,unique = false )
    private String imageUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    private Auction auction;

    @ManyToMany(mappedBy = "boatList")
    private List<User> userList;

    public Boat() {
    }

    public Boat(Long id, String name, String brand, String make, String year, String imageUrl) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.make = make;
        this.year = year;
        this.imageUrl = imageUrl;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Boat)) return false;
        Boat boat = (Boat) o;
        return Objects.equals(getId(), boat.getId()) && Objects.equals(getName(), boat.getName()) && Objects.equals(getBrand(), boat.getBrand()) && Objects.equals(getMake(), boat.getMake()) && Objects.equals(getYear(), boat.getYear()) && Objects.equals(getImageUrl(), boat.getImageUrl()) && Objects.equals(getAuction(), boat.getAuction()) && Objects.equals(getUserList(), boat.getUserList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getBrand(), getMake(), getYear(), getImageUrl(), getAuction(), getUserList());
    }
}


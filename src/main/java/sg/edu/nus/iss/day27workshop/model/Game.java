package sg.edu.nus.iss.day27workshop.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "games")
public class Game implements Serializable {
    
    @Id
    private Integer gid;
    private String name;
    private Integer year;
    private Integer rating;
    private Integer userRating;
    
    public Game() {
    }

    public Game(Integer gid, String name, Integer year, Integer rating, Integer userRating) {
        this.gid = gid;
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.userRating = userRating;
    }

    public Integer getGid() {
        return gid;
    }
    public void setGid(Integer gid) {
        this.gid = gid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    public Integer getUserRating() {
        return userRating;
    }
    public void setUserRating(Integer userRating) {
        this.userRating = userRating;
    }

    @Override
    public String toString() {
        return "Game [gid=" + gid + ", year=" + year + ", rating=" + rating + ", userRating=" + userRating + "]";
    }
    
}

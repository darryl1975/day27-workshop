package sg.edu.nus.iss.day27workshop.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
// import org.springframework.data.mongodb.core.mapping.Document;

import org.bson.Document;
import jakarta.json.Json;
import jakarta.json.JsonObject;

// @Document(collection = "games")
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

    // used to convert from Document to entity object
    public static Game create(Document d) { 
        Game game = new Game();
        game.setGid(d.getInteger("gameId"));
        game.setName(d.getString("name"));
        game.setYear(d.getInteger("year"));
        game.setRating(d.getInteger("rating"));
        game.setUserRating(d.getInteger("userRating"));
        return game;
    }

    // used to convert from entity object to json string
    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("gid", getGid())
                .add("name", getName())
                .add("year", getYear())
                .add("rating", getRating())
                .add("userRating", getUserRating())
                .build();
    }

}

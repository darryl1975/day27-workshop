package sg.edu.nus.iss.day27workshop.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.json.Json;
import jakarta.json.JsonObjectBuilder;

public class EditedComment implements Serializable {

    private Integer cid;
    private Integer rating;
    private String comment;
    private LocalDateTime posted;

    public Integer getCid() {
        return cid;
    }
    public void setCid(Integer cid) {
        this.cid = cid;
    }
    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public LocalDateTime getPosted() {
        return posted;
    }
    public void setPosted(LocalDateTime posted) {
        this.posted = posted;
    }

    public JsonObjectBuilder toJSON() {
        return Json.createObjectBuilder()
            .add("comment", getComment())
            .add("rating", getRating())
            .add("posted", getPosted().toString());
    }
    
    
}

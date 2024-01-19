package sg.edu.nus.iss.day27workshop.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;

@Document(collection = "reviews")
public class Review extends EditedComment {

    @Id
    private Integer reviewId;
    private Integer gameId;
    private String gameName;
    private String user;

    // List edited comments --> common attributed put into Parent object
    // EditedComment
    // private Integer rating;
    // private String comment;
    // private LocalDateTime posted;

    private List<EditedComment> edited;

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<EditedComment> getEdited() {
        return edited;
    }

    public void setEdited(List<EditedComment> edited) {
        this.edited = edited;
    }

    public void addEditedComment(EditedComment e) {
        this.edited.add(e);
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("gid", getGameId())
                .add("comment", getComment())
                .add("rating", getRating())
                .add("user", getUser())
                .add("posted", getPosted().toString())
                .add("cid", getCid())
                .build();
    }

    public JsonObject toJsonEdited() {
        boolean isEditedComment = false;
        if (this.getEdited() != null) {
            List<JsonObjectBuilder> editComments = this.getEdited()
                    .stream()
                    .map(t -> t.toJSON())
                    .toList();

            if (editComments.size() > 0) {
                isEditedComment = true;
            }
        }

        return Json.createObjectBuilder()
                .add("gid", getGameId())
                .add("comment", getComment())
                .add("rating", getRating())
                .add("user", getUser())
                .add("posted", getPosted().toString())
                .add("name", getGameName())
                .add("edited", isEditedComment)
                .build();
    }

    public JsonObject toJsonEditedList() {
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        List<JsonObjectBuilder> editComments = this.getEdited()
                .stream()
                .map(t -> t.toJSON())
                .toList();

        for (JsonObjectBuilder j : editComments) {
            arrBuilder.add(j);
        }

        return Json.createObjectBuilder()
                .add("gid", getGameId())
                .add("comment", getComment())
                .add("rating", getRating())
                .add("user", getUser())
                .add("posted", getPosted().toString())
                .add("name", getGameName())
                .add("edited", arrBuilder)
                .build();
    }
}

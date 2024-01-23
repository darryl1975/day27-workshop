package sg.edu.nus.iss.day27workshop.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.client.result.UpdateResult;

import sg.edu.nus.iss.day27workshop.model.Review;

@Repository
public class ReviewRepo {
    
    @Autowired
    MongoTemplate mt;


    public Review getReviewById(Integer reviewId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(reviewId));
        
        return mt.findOne(query, Review.class);
    }

    public Review createReview(Review r) {
        return mt.insert(r, "reviews");
    }

    public long updateReview(Review r) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(r.getCid()));

        Update updateOps = new Update()
        .set("rating", r.getRating())
        .set("comment", r.getComment())
        .set("posted", r.getPosted())
        .set("edited", r.getEdited());

        UpdateResult result = mt.updateMulti(query, updateOps, Review.class, "reviews");

        return result.getMatchedCount();

    }
}

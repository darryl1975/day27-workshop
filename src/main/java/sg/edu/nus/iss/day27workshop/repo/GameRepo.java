package sg.edu.nus.iss.day27workshop.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import sg.edu.nus.iss.day27workshop.model.Game;

@Repository
public class GameRepo {

    @Autowired
    MongoTemplate mt;

    public List<Game> getAllGames() {
        List<Game> games = mt.findAll(Game.class);
        return games;
    }

    public List<Game> getAllGamesPaginated(int limit, int offset) {

        Query query = new Query();
        query.skip(limit * offset);
        query.limit(limit);

        // Pageable pageable = PageRequest.of(offset, limit);
        // query.with(pageable);

        List<Game> games = mt.find(query, Game.class);

        return games;
    }

    public Game createGame(Game g) {

        Game createdGame = mt.save(g);
        return createdGame;
    }

    public long updateGame(Game g) {
        Query query = Query.query(Criteria.where("_id").is(g.getGid()));

        Update updOps = new Update()
                .set("name", g.getName())
                .set("rating", g.getRating())
                .set("userRating", g.getUserRating())
                .set("year", g.getYear());

        UpdateResult result = mt.updateMulti(query, updOps, Game.class, "games");

        return result.getModifiedCount();
    }

    public long deleteGame(int id) {

        Query query = new Query(Criteria.where("_id").is(id));

        DeleteResult result = mt.remove(query, "games");

        return result.getDeletedCount();
    }

    public List<Game> findByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));

        return mt.find(query, Game.class);
    }

    public Game findById(Integer id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));

        return mt.findOne(query, Game.class, "games");
    }

}

package sg.edu.nus.iss.day27workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.day27workshop.model.Game;
import sg.edu.nus.iss.day27workshop.repo.GameRepo;

@Service
public class GameService {
    
    @Autowired
    GameRepo gameRepo;

    public List<Game> getAllGames() {
        return gameRepo.getAllGames();
    }

    public List<Game> getAllGamesPaginated(int limit, int offset) {
        return gameRepo.getAllGamesPaginated(limit, offset);
    }

    public Game createGame(Game game) {
        return gameRepo.createGame(game);
    }

    public long updateGame(Game game) {
        return gameRepo.updateGame(game);
    }

    public long deleteGame(Game game) {
        return gameRepo.deleteGame(game.getGid());
    }
}

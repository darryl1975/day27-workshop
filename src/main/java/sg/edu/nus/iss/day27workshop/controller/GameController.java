package sg.edu.nus.iss.day27workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.day27workshop.model.Game;
import sg.edu.nus.iss.day27workshop.service.GameService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping()
    public ResponseEntity<List<Game>> getAllGames() {
        List<Game> games = gameService.getAllGames();

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(games);
    }

    // Pagination GetMapping parameters passed in as @RequestParam

    @PostMapping()
    public ResponseEntity<Game> createGame(@RequestBody Game game) {

        Game savedGame = gameService.createGame(game);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(savedGame);
    }

    @PutMapping()
    public ResponseEntity<Long> updateGame(@RequestBody Game editedgame) {

        Long result = gameService.updateGame(editedgame);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);
    }

    @DeleteMapping()
    public ResponseEntity<Long> deleteGame(@RequestBody Game gameToDelete) {

        Long result = gameService.deleteGame(gameToDelete);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);
    }

}

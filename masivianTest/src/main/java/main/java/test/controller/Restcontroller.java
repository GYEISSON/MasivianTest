package main.java.test.controller;
import main.java.test.model.Bet;
import main.java.test.service.implement.TestServiceImplement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@RequestMapping("/testRoulette")
public class Restcontroller {
	@Autowired
	private TestServiceImplement testService;
	@PostMapping("/create")
	public ResponseEntity<?> createRoulette() {
        try {
            int idRoulette =testService.createRoulette();

            return new ResponseEntity<>(idRoulette,HttpStatus.CREATED);
        }catch (Exception e){
        	
            return  new ResponseEntity<>("The roulette didn't create", HttpStatus.FORBIDDEN);
        }
	}
	@PatchMapping("/open/{idRoulette}")
	public ResponseEntity<?> openRoulette(@PathVariable Integer idRoulette) {
        try {
        	testService.openRoulette(idRoulette);	
        	
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e){
        	
            return  new ResponseEntity<>("The roulette didn't open", HttpStatus.NOT_FOUND);
        }
	}
	@PutMapping("/make/{bet}")
	public ResponseEntity<?> makeBet(@RequestBody Bet bet){
        try {
        	testService.makeBet(bet);

            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e){
        	
            return  new ResponseEntity<>("The bet didn't make", HttpStatus.NOT_FOUND);
        }
	}
	@GetMapping("/close/{idRoulette}")
	public ResponseEntity<?> closeBet(@PathVariable Integer idRoulette){
        try {
            byte winningBeat = testService.closeBet(idRoulette);

            return new ResponseEntity<>(winningBeat,HttpStatus.ACCEPTED);
        }catch (Exception e){
        		
            return  new ResponseEntity<>("The roulette didn't close", HttpStatus.NOT_FOUND);
        }
	}
	@GetMapping("/getRoulettes")
	public ResponseEntity<?> getRoulettes(){
        try {
            List<Roulette> rouletes = testService.createdRoulettes();

            return new ResponseEntity<>(,HttpStatus.ACCEPTED);
        }catch (Exception e){
        	
            return  new ResponseEntity<>("The roulette didn't listed", HttpStatus.NOT_FOUND);
        }
	}
}

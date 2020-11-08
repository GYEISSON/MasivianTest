package main.java.test.controller;
import main.java.test.service.implement.TestServiceImplement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@RequestMapping("/testRoulette")
public class Restcontroller {
	@Autowired
	private TestServiceImplement testService;
	@RequestMapping("/")
	public String index() {
		
		return "Greetings from Spring Boot!";
	}
	@PostMapping("/create")
	public ResponseEntity<Object> create() {
        try {
        	System.out.println("Roulette created !");
        		
            return new ResponseEntity<>(testService.createRoulette(),HttpStatus.CREATED);
        }catch (Exception e){
        	
            return  new ResponseEntity<>("The roulette didn't create", HttpStatus.FORBIDDEN);
        }
	}
	@PatchMapping("/open/{idRoulette}")
	public ResponseEntity<Object> openRoulette(@PathVariable Integer idRoulette) {
        try {
        	testService.openRoulette(idRoulette);	
        	
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e){
        	
            return  new ResponseEntity<>("The roulette didn't open", HttpStatus.NOT_FOUND);
        }
	}
}

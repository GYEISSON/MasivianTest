package main.java.test.service.implement;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import main.java.test.service.TestService;
import main.java.test.model.Roulette;
@Service
public class TestServiceImplement implements TestService{
	private static int idRoulette;
	private ArrayList<Roulette> roulettes;
	public TestServiceImplement() {
		idRoulette=1;
		roulettes= new ArrayList<Roulette>();
	} 
	@Override
	public int createRoulette() {
		roulettes.add(new Roulette(idRoulette));
		
		return idRoulette++;
	}
	@Override
	public void openRoulette(int idRoulette) {
		roulettes.get(idRoulette).open();
	}
}

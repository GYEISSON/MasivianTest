package main.java.test.service;
import java.util.List;
import main.java.test.model.Bet;
import main.java.test.model.Roulette;
public interface TestService {
	int createRoulette();
	void openRoulette(int idRoulette);
	void makeBet(Bet bet);
	byte closeBet(int idRoulette);
	List<String> createdRoulettes();
}

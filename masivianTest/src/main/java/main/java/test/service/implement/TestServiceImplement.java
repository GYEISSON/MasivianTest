package main.java.test.service.implement;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import main.java.test.service.TestService;
import main.java.test.model.Bet;
import main.java.test.model.Roulette;
import main.java.test.model.User;
@Service
public class TestServiceImplement implements TestService{
	private static int idRoulette;
	private static int idUser;
	private HashMap<Integer,Roulette> roulettes;
	
	private HashMap<Integer,User> users;
	public TestServiceImplement() {
		idRoulette=1;
		roulettes=new HashMap<Integer,Roulette>();
	} 
	@Override
	public int createRoulette() {
		roulettes.put(idRoulette,new Roulette(idRoulette));
		
		return idRoulette++;
	}
	@Override
	public void openRoulette(int idRoulette) {
		roulettes.get(idRoulette).open();
	}
	@Override
	public void makeBet(Bet bet) {
		roulettes.get(idRoulette).addBet(bet);
		if(!users.containsKey(bet.getUserId())) {
			users.put(idUser, new User(idUser));
		}
	}
	@Override
	public byte closeBet(int idRoulette) {
		Roulette roulette = roulettes.get(idRoulette);
		byte winnerNumber = roulette.close();
		for(Bet bet: roulette.winnerBets()) {
			User user= users.get(bet.getUserId());
			if(bet.getExpectedNumber() == winnerNumber ) {
				user.changeBalance(bet.getValue()*5);
			}
			else {
				user.changeBalance(bet.getValue()*1.8);
			}
		}
		
		return winnerNumber;
	}
	@Override
	public List<String> createdRoulettes() {
		List<String> rouletteList= new ArrayList<String>();
		for (HashMap.Entry<Integer, Roulette> roulette : roulettes.entrySet()) {
		    rouletteList.add( roulette.getKey() + ":" + roulette.getValue().isOpen());
		}
		return rouletteList;
	}
}

package main.java.test.persistence;
import org.springframework.data.repository.CrudRepository;
import main.java.test.model.Bet;
public interface BetPersistence  extends CrudRepository<Bet,Integer>  {
	
}

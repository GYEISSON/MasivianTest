package main.java.test.persistence;
import org.springframework.data.repository.CrudRepository;
import main.java.test.model.Roulette;
public interface RoulettePersistence extends CrudRepository<Roulette,Integer> {

}

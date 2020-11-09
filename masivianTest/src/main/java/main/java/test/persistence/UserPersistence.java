package main.java.test.persistence;
import org.springframework.data.repository.CrudRepository;
import main.java.test.model.User;
public interface UserPersistence extends CrudRepository<User,Integer>  {
}

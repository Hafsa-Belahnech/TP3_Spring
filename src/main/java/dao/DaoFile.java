package dao;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("daoFile")
@Profile("file") //commenté ou non, selon le cas d'utilisation
public class DaoFile implements IDao {
    @Override public double getValue(){ return 280.0; }
}

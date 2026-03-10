package dao;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("daoApi")
@Profile("api") //on le commente si on n'utilise pas cette classe
public class DaoApi implements IDao {
    @Override public double getValue(){ return 222.0; }
}

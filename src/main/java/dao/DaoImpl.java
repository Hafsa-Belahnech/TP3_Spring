package dao;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod") //commenté si n'est pas utilisé
public class DaoImpl implements IDao {
    @Override public double getValue(){ return 300.0; }
}

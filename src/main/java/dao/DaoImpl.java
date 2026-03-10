package dao;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Profile("prod")
public class DaoImpl implements IDao {
    @Override public double getValue(){ return 200.0; }
}
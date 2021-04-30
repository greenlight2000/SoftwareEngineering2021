import com.group56.model.dao.CustomerDAO;
import com.group56.model.dao.Impl.CustomerDAOImpl;
import com.group56.model.entity.Customer;
import org.junit.jupiter.api.Test;

public class daoTest {
    CustomerDAO dao = new CustomerDAOImpl();
    @Test
    public void insert(){
        dao.insert(new Customer("1","wyk","gogogo","男酮","男","18","2021-1-1","180","63"));
    }

}

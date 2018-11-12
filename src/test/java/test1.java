import com.baizhi.dao.deptDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class test1 {
    @Autowired
    private deptDAO deptDAO;
    @Test
    public void findall(){

      //  List<dept> list = deptDAO.findAll();
      //  JSONArray jsonArray = JSONArray.fromObject(list);
        //System.out.println(jsonArray.toString());

    }
}

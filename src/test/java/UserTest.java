import demo.dao.UserDao;
import demo.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: GMH
 * @create: 2020-02-08
 * @Description：
 * @Modified By：
 * @Version: 1.0.0
 */
public class UserTest {
    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("demo/SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession(true);
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void destroy()throws Exception{
        sqlSession.close();
        in.close();
    }

    @Test
    public void getUerById(){
        List<User> users = userDao.findById(1);
        for(User user:users){
            System.out.println("姓名:"+user.getName()+"性别:"+user.getSex());
        }
    }

    @Test
    public void getUerByName(){
        List<User> list = userDao.findByName("%张三%");
        for(User user:list){
            System.out.println(user.getName());
        }
    }

    @Test
    public void insertData(){
        User user = new User();
        user.setId(5);
        user.setName("李四");
        user.setSex(1);
        int num =userDao.insertData(user);
        System.out.println("插入成功，插入记录数：" + num);
    }

    @Test
    public void deleteData(){
        int num = userDao.deleteData(5);
        System.out.println("删除成功，删除记录数：" + num);
    }

    @Test
    public void updateData(){
        User user = new User();
        user.setId(1);
        user.setName("用户111");
        int num =userDao.updateData(user);
        System.out.println("更新成功，更新记录数：" + num);
    }

    @Test
    public void findByNameIf(){
        User user = new User();
        user.setName("%用户%");
        List<User> list = userDao.findByNameIf(user);
        System.out.println("查找结果数：" + list.size());
    }

    @Test
    public void findByIdForeach(){
        User user = new User();
        List listTemp = new ArrayList();
        listTemp.add(1);
        listTemp.add(2);
        user.setIds(listTemp);
        List<User> list = userDao.findByIdForeach(user);
        for(User user1:list){
            System.out.println("foreach查找结果：id=" + user1.getId() + ", 姓名=" +  user1.getName());
        }
    }
}

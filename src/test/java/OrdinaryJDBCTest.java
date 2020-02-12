import org.junit.Test;

import java.sql.*;

/**
 * @author: GMH
 * @create: 2020-02-07
 * @Description：
 * @Modified By：
 * @Version: 1.0.0
 */
public class OrdinaryJDBCTest {
    @Test
    public void ordinaryJDBC() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            //加载数据库驱动
            Class.forName("oracle.jdbc.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:orcl";
            String user="test";
            String password="test";
            //通过驱动管理类获取数据库链接
            conn = DriverManager.getConnection(url,user,password);
            String sql = "select * from test.t_test where id = ?";
            //获取预处理statement
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,1);
            rs = pstm.executeQuery();
            while (rs.next()){
                System.out.println("姓名:"+rs.getString("name")+";性别:"+rs.getString("sex"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstm.close();;
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}

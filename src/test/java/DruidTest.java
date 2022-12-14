import com.softeem.util.DruidConn;
import org.junit.Test;

import java.sql.Connection;

/**
 * @program: JavaWeb
 * @description:
 * @author: ZD
 * @create: 2022-12-09 00:03
 **/

public class DruidTest {

    @Test
    public void test01() {
        int x = 0;
// 获取20个连接对象，输出连接对象，地址值不同
        for (int i = 1; i < 101; i++) {
            Connection connection = DruidConn.getConn();
            System.out.println(connection+"x-->" + x++);

            // 调用关闭连接对象的方法后，发现获取的20个连接对象地址值是同一个，说明每次从连接池中取出的连接对象是同一个
            DruidConn.close(connection, null, null);
        }
    }
}
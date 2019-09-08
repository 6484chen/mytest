import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName ClassLoaderTest
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/21 22:52
 * @Version 1.0
 */
public class ClassLoaderTest {

    @Test
    public void test1(){
        ClassLoader clt  = ClassLoaderTest.class.getClassLoader();
        System.out.println(clt);

        ClassLoader clt1 = clt.getParent();
        System.out.println(clt1);

        ClassLoader clt2 = clt1.getParent();
        System.out.println(clt2);

    }

    @Test
    public void test2() throws IOException {
        Properties pro = new Properties();

        ClassLoader clt  = ClassLoaderTest.class.getClassLoader();
        InputStream resourceAsStream = clt.getResourceAsStream("jdbc1.properties");
        pro.load(resourceAsStream);


        //文件默认为model路径下
        //FileInputStream fis = new FileInputStream("jdbc.properties");
        //FileInputStream fis = new FileInputStream("src\\jdbc.properties");
        //pro.load(fis);



        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        System.out.println(user + " : " + password);


    }
}

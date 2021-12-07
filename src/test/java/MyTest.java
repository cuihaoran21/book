import com.cuihaoran.pojo.Books;
import com.cuihaoran.service.BookService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chr
 * @create 2021-12-07-9:52
 */
public class MyTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl =(BookService) context.getBean("BookServiceImpl");
        for (Books books : bookServiceImpl.queryAllBook()){
            System.out.println(books);
//            Books books1 = bookServiceImpl.queryBookById(3);
//            System.out.println(books1);
        }
    }
}

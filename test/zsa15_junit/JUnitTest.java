package zsa15_junit;

import org.junit.Test;
import static org.junit.Assert.*;

import static javafxapplication.FXMLDocumentController.comp;

public class JUnitTest {
        
    @Test
    public void test1FXML() throws Exception {
        assertTrue(comp(2, 0, 4) == 24.25);
        assertTrue(comp(4, 2, 2) == 16.00);
        assertTrue("Проверка ", comp(4, 2, 5) == 324.0);
    }
    
    @Test
    public void test2FXML() throws Exception {
        try {
            assertTrue("Проверка деления на 0", comp(4, 2, 0) == 0);
            fail("Нет ошибки при делении на 0");
        } catch (Exception thrown) {
            assertNotEquals("", thrown.getMessage());
        }
        try {
            assertTrue("Проверка деления 0 на 0", comp(0, 10, 0) == 0);
            fail("Нет ошибки при делении 0 на 0");
        } catch (Exception thrown) {
            assertNotEquals("", thrown.getMessage());
        }
    }

}
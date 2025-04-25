package project;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class OrderTest {

    @Test
    public void testCalculateTotal_standardShippingRiyadh() {
        Order order = new Order(200.0, "Standard", "Riyadh");
        double expected = 215.0; // 200 + 5 (Standard) + 10 (Riyadh city)
        double actual = order.calculateTotal();
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testCalculateTotal_nextDayShippingDammam() {
        Order order = new Order(200.0, "NextDay", "Dammam");
        double expected = 230.0; // 200 + 20 (NextDay) + 10 (Dammam city)
        double actual = order.calculateTotal();
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testCalculateTotal_standardShippingNon() {
        Order order = new Order(200.0, "Standard", "Non");
        double expected = 220.0; // 200 + 5 (Standard) + 15 (Non)
        double actual = order.calculateTotal();
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testCalculateTotal_nextDayShippingNon() {
        Order order = new Order(200.0, "NextDay", "Non");
        double expected = 235.0; // 200 + 20 (NextDay) + 15 (Non)
        double actual = order.calculateTotal();
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testCalculateTotal_zeroCost() {
        Order order = new Order(0.0, "Standard", "Riyadh");
        double expected = 15.0; // 0 + 5 (Standard) + 10 (Riyadh city)
        double actual = order.calculateTotal();
        assertEquals(expected, actual, 0.001);
    }
}

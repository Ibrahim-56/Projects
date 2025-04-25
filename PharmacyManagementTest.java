package std;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class PharmacyManagementTest {

    private PharmacyManagement pharmacyManagement;
    private Drug drug1;
    private Drug drug2;

    @BeforeEach
    public void setUp() {
        pharmacyManagement = new PharmacyManagement();
        drug1 = new Drug("Aspirin", "Painkiller", 100, 0.50);
        drug2 = new Drug("Paracetamol", "Painkiller", 200, 0.30);
        pharmacyManagement.addDrug(drug1);
        pharmacyManagement.addDrug(drug2);
    }

    @Test
    public void testAddDrug() {
        Drug drug3 = new Drug("Ibuprofen", "Painkiller", 150, 0.40);
        pharmacyManagement.addDrug(drug3);
        List<Drug> drugs = pharmacyManagement.getDrugs();
        assertEquals(3, drugs.size());
        assertTrue(drugs.contains(drug3));
    }

    @Test
    public void testCheckStock() {
        int stock = pharmacyManagement.checkStock("Aspirin");
        assertEquals(100, stock);
    }

    @Test
    public void testProcessSale() {
        double totalPrice = pharmacyManagement.processSale("Aspirin", 10);
        assertEquals(5.0, totalPrice);
        assertEquals(90, drug1.getStock());
    }

    @Test
    public void testUpdateStock() {
        pharmacyManagement.updateStock("Aspirin", 50);
        assertEquals(150, drug1.getStock());
    }

    @Test
    public void testNonExistentDrug() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            pharmacyManagement.checkStock("NonExistentDrug");
        });
        assertEquals("Drug not found", exception.getMessage());
    }

    @Test
    public void testInsufficientStock() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            pharmacyManagement.processSale("Aspirin", 200);
        });
        assertEquals("Insufficient stock", exception.getMessage());
    }
}

package std;

import java.util.List;
import java.util.ArrayList;

public class PharmacyManagement {
  private List<Drug> drugs = new ArrayList<>();

  public void addDrug(Drug drug) {
    drugs.add(drug);
  }

  public List<Drug> getDrugs() {
    return drugs;
  }

  public int checkStock(String drugName) {
    return drugs.stream()
                .filter(drug -> drug.getName().equalsIgnoreCase(drugName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Drug not found"))
                .getstock();
  }

  public double processSale(String drugName, int quantity) {
    Drug drug = drugs.stream()
                     .filter(d -> d.getName().equalsIgnoreCase(drugName))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("Drug not found"));
    if (drug.getstock() < quantity) {
      throw new IllegalArgumentException("Insufficient stock");
    }
    drug.setstock(drug.getstock() - quantity);
    return quantity * drug.getpricePerUnit();
  }

  public void updateStock(String drugName, int quantity) {
    Drug drug = drugs.stream()
                     .filter(d -> d.getName().equalsIgnoreCase(drugName))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("Drug not found"));
    drug.setstock(drug.getstock() + quantity);
  }
}

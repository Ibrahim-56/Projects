package project;
public class Order {
    private double cost;
    private String shippingMethod;
    private String destinationState;

    public Order(double cost, String shippingMethod, String destinationState) {
        this.cost = cost;
        this.shippingMethod = shippingMethod;
        this.destinationState = destinationState;
    }
    
    public double calculateTotal() {
        double shippingCost = 0.0;
        if (shippingMethod.equals("Standard")) {
            shippingCost = 5.0;
        } else if (shippingMethod.equals("NextDay")) {
            shippingCost = 20.0;
        }

        if (destinationState.equals("Riyadh") || destinationState.equals("Dammam") || 
            destinationState.equals("Hail") || destinationState.equals("Qasim")) {
            shippingCost += 10.0;
        } else {
            shippingCost += 15.0;
        }

        return cost + shippingCost;
    }

    
}


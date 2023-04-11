package met.local.model;

public class CartItem {
    private final Game product;
    private int quantity;
    private double subTotal;

    public CartItem(Game product) {
        this.product = product;
        this.quantity = 1;
        this.subTotal = product.getPrice();
    }

    public Game getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        subTotal = product.getPrice() * quantity;
        return subTotal;
    }
}
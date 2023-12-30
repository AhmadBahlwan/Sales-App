package bahlawan.com.salesmanagementsystem.dtos;

public class CreateSaleRequest {

    private int clientId;
    private String seller;
    private double price;
    private int quantity;

    public CreateSaleRequest() {
    }

    public CreateSaleRequest(int clientId, String seller, double price, int quantity) {
        this.clientId = clientId;
        this.seller = seller;
        this.price = price;
        this.quantity = quantity;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

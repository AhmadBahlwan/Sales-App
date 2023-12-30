package bahlawan.com.salesmanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private int saleId;

    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime creationDte;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "seller")
    private String seller;

    @Column(name = "price")
    @JsonIgnore
    private double price;

    @Column(name = "quantity")
    @JsonIgnore
    private int quantity;

    @Column(name = "total")
    private double total;

    public Sale() {
    }

    public Sale(Client client, String seller, double price, int quantity, double total) {
        this.client = client;
        this.seller = seller;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public LocalDateTime getCreationDte() {
        return creationDte;
    }

    public void setCreationDte(LocalDateTime creationDte) {
        this.creationDte = creationDte;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

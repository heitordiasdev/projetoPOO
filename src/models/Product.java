package models;

public class Product {

    private String produto;
    private double price;

    public String getProduto(int i) {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getPrice(int i) {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}



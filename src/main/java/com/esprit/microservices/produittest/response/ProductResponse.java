package com.esprit.microservices.produittest.response;

public class ProductResponse {

    private BlogResponse blogResponse;
    private Long id ;
    private String productName ;
    private String description;
    private int price;
    private int reference ;
    private int quantity;

    private String image;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BlogResponse getBlogResponse() {
        return blogResponse;
    }

    public void setBlogResponse(BlogResponse blogResponse) {
        this.blogResponse = blogResponse;
    }
}

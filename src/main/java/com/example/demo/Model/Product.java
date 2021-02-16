package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {
    @NotBlank
    private String name;
    @NotBlank
    private String color;
    @NotBlank
    private String Price;
    private String company;

    //----------------------------------------Constructor--------------------------------------

    public Product(@JsonProperty("name") String name,
                   @JsonProperty("Color") String color,
                   @JsonProperty("Price") String price,
                   @JsonProperty("Company") String company) {
        this.name = name;
        this.color = color;
        this.Price = price;
        this.company = company;
    }

    //----------------------------------------Setter-------------------------------------------


    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    //---------------------------------------Getter-------------------------------------------


    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getPrice() {
        return Price;
    }

    public String getCompany() {
        return company;
    }

    //--------------------------------------To String-----------------------------------------

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", Price=" + Price +
                ", company='" + company + '\'' +
                '}';
    }

    //---------------------------------------Compare-----------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(color, product.color) &&
                Objects.equals(Price, product.Price) &&
                Objects.equals(company, product.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, Price, company);
    }


    //----------------------------------------------------------------------------------------

}//END Of CLASS------------------------------------------------------------------------------

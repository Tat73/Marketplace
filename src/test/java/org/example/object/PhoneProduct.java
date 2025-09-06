package org.example.object;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class PhoneProduct extends BaseProduct {

    private String size;
    private String color;
    private String serviceProvider;

    public PhoneProduct() {
    }

    public PhoneProduct(List<String> data) {
        super(data);
        this.size = data.get(1);
        this.color = data.get(2);
        this.serviceProvider = data.get(3);
    }

    @Override
    public String toString() {
        return "PhoneProduct{" +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", serviceProvider='" + serviceProvider + '\'' +
                '}';
    }
}

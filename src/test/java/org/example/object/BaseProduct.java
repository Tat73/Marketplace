package org.example.object;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode
public class BaseProduct {

    private String name;

    public BaseProduct(List<String> data) {
        this.name = data.getFirst();
    }

    public BaseProduct() {
    }

    @Override
    public String toString() {
        return "BaseProduct{" +
                "name='" + name +
                '}';
    }
}

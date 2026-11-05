package Example_4_SortByDecimal;

import java.util.*;

class Product implements Comparable<Product> {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Product other) {
        return Double.compare(this.price, other.price);   // cheapest first
    }

    @Override
    public String toString() {
        return name + " $" + price;
    }
}

public class Example4 {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new Product("Laptop", 55000.0));
        list.add(new Product("Mouse", 500.5));
        list.add(new Product("Keyboard", 1500.0));

        Collections.sort(list);
        System.out.println(list);
    }
}
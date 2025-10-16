class Product {
    int productId;
    String productName;

    Product(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product p = (Product) obj;
        return productId == p.productId;
    }
}

public class HW2_EqualsVsDoubleEqual {
    public static void main(String[] args) {
        Product p1 = new Product(1, "Pen");
        Product p2 = new Product(1, "Pen");

        System.out.println("Using == : " + (p1 == p2));
        System.out.println("Using equals() : " + p1.equals(p2));
    }
}


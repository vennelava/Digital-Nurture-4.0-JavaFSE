public class LinearSearch {
    public static Product searchById(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product;
            }
        }
        return null; // not found
    }
}

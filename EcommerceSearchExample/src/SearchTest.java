public class SearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(202, "Shoes", "Fashion"),
            new Product(303, "Watch", "Accessories"),
            new Product(404, "Phone", "Electronics"),
            new Product(505, "Bag", "Fashion")
        };

        // Test Linear Search
        Product result1 = LinearSearch.searchById(products, 303);
        if (result1 != null) {
            System.out.println("Linear Search Found: " + result1.getProductName());
        } else {
            System.out.println("Linear Search: Product not found.");
        }

        // Sort before Binary Search
        BinarySearch.sortByProductId(products);

        // Test Binary Search
        Product result2 = BinarySearch.searchById(products, 303);
        if (result2 != null) {
            System.out.println("Binary Search Found: " + result2.getProductName());
        } else {
            System.out.println("Binary Search: Product not found.");
        }
    }
}

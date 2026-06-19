class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class EcommerceSearch {

    // Linear Search
    public static Product linearSearch(Product[] products, int key) {
        for (Product product : products) {
            if (product.productId == key) {
                return product;
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, int key) {
        int low = 0, high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (products[mid].productId == key)
                return products[mid];
            else if (products[mid].productId < key)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Phone", "Electronics"),
                new Product(103, "Shoes", "Fashion"),
                new Product(104, "Watch", "Accessories"),
                new Product(105, "Bag", "Fashion")
        };

        int searchId = 103;

        // Linear Search Timing
        long startLinear = System.nanoTime();
        Product result1 = linearSearch(products, searchId);
        long endLinear = System.nanoTime();

        // Binary Search Timing
        long startBinary = System.nanoTime();
        Product result2 = binarySearch(products, searchId);
        long endBinary = System.nanoTime();

        // Display Linear Search Result
        if (result1 != null) {
            System.out.println("Linear Search Found:");
            System.out.println("Product ID: " + result1.productId);
            System.out.println("Product Name: " + result1.productName);
            System.out.println("Category: " + result1.category);
        }

        System.out.println("Time taken by Linear Search: "
                + (endLinear - startLinear) + " nanoseconds");

        // Display Binary Search Result
        if (result2 != null) {
            System.out.println("\nBinary Search Found:");
            System.out.println("Product ID: " + result2.productId);
            System.out.println("Product Name: " + result2.productName);
            System.out.println("Category: " + result2.category);
        }

        System.out.println("Time taken by Binary Search: "
                + (endBinary - startBinary) + " nanoseconds");
    }
}
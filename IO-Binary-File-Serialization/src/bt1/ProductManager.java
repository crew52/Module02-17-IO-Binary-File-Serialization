package bt1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private static final String FILE_NAME = "products.dat";

    // Thêm sản phẩm vào tệp nhị phân
    public void addProduct(Product product) {
        List<Product> products = readProducts(); // Đọc danh sách hiện tại
        products.add(product); // Thêm sản phẩm mới

        // Ghi lại toàn bộ danh sách vào tệp
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(products);
            System.out.println("Thêm sản phẩm thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hiển thị danh sách sản phẩm
    public void displayProducts() {
        List<Product> products = readProducts();
        if (products.isEmpty()) {
            System.out.println("Không có sản phẩm nào!");
        } else {
            products.forEach(System.out::println);
        }
    }

    // Tìm kiếm sản phẩm theo mã
    public void searchProduct(String id) {
        List<Product> products = readProducts();
        for (Product product : products) {
            if (product.getId().equalsIgnoreCase(id)) {
                System.out.println("Tìm thấy sản phẩm: " + product);
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm với mã: " + id);
    }

    // Đọc danh sách sản phẩm từ tệp
    @SuppressWarnings("unchecked")
    private List<Product> readProducts() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>(); // Trả về danh sách rỗng nếu tệp chưa tồn tại
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Product>) ois.readObject(); // Đọc danh sách từ tệp
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}

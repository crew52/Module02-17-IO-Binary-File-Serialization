package bt1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Quản lý sản phẩm ---");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm theo mã");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ ký tự xuống dòng

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã sản phẩm: ");
                    String id = scanner.nextLine();
                    System.out.print("Nhập tên sản phẩm: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập giá sản phẩm: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Đọc bỏ ký tự xuống dòng
                    System.out.print("Nhập hãng sản xuất: ");
                    String manufacturer = scanner.nextLine();
                    System.out.print("Nhập mô tả sản phẩm: ");
                    String description = scanner.nextLine();

                    Product product = new Product(id, name, price, manufacturer, description);
                    productManager.addProduct(product);
                    break;

                case 2:
                    productManager.displayProducts();
                    break;

                case 3:
                    System.out.print("Nhập mã sản phẩm cần tìm: ");
                    String searchId = scanner.nextLine();
                    productManager.searchProduct(searchId);
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
            }
        }
    }
}

package opt1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class BinaryFileCopy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập đường dẫn file nguồn
        System.out.print("Nhập đường dẫn file nguồn: ");
        String sourcePath = scanner.nextLine();

        // Nhập đường dẫn file đích
        System.out.print("Nhập đường dẫn file đích: ");
        String targetPath = scanner.nextLine();

        // Kiểm tra file nguồn tồn tại
        File sourceFile = new File(sourcePath);
        if (!sourceFile.exists()) {
            System.out.println("File nguồn không tồn tại.");
            return;
        }

        // Kiểm tra nếu file đích đã tồn tại
        File targetFile = new File(targetPath);
        if (targetFile.exists()) {
            System.out.println("File đích đã tồn tại. Bạn có muốn ghi đè không? (y/n): ");
            String overwrite = scanner.nextLine();
            if (!overwrite.equalsIgnoreCase("y")) {
                System.out.println("Sao chép bị hủy.");
                return;
            }
        }

        // Thực hiện sao chép file
        try (
                FileInputStream fis = new FileInputStream(sourceFile);
                FileOutputStream fos = new FileOutputStream(targetFile)
        ) {
            byte[] buffer = new byte[1024]; // Bộ đệm 1 KB
            int bytesRead;
            int totalBytes = 0;

            // Đọc và ghi từng khối byte
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
                totalBytes += bytesRead;
            }

            System.out.println("Sao chép hoàn tất.");
            System.out.println("Tổng số byte trong tệp: " + totalBytes);

        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi sao chép tệp: " + e.getMessage());
        }
    }
}
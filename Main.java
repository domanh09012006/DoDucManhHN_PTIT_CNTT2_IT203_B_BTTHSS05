import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product manager = new Product("", "", 0, 0, "");
        int choice;
        do {
            System.out.println("""
                    ========= PRODUCT MANAGEMENT SYSTEM =========
                    1. Thêm sản phẩm mới
                    2. Hiển thị danh sách sản phẩm
                    3. Cập nhật số lượng theo ID
                    4. Xóa sản phẩm đã hết hàng
                    5. Thoát chương trình
                    =============================================
                    """);
            System.out.print("Lựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    try {
                        System.out.print("Nhập ID: ");
                        String id = sc.nextLine();
                        System.out.print("Nhập tên sản phẩm: ");
                        String name = sc.nextLine();
                        System.out.print("Nhập giá: ");
                        double price = sc.nextDouble();
                        System.out.print("Nhập số lượng: ");
                        int quantity = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nhập danh mục: ");
                        String category = sc.nextLine();
                        Product p = new Product(id, name, price, quantity, category);
                        manager.addProduct(p);
                        System.out.println("Thêm sản phẩm thành công!");
                    } catch (InvalidProductException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    manager.getAllProducts();
                    break;
                case 5:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 5);
    }
}
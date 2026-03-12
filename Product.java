/*
* Kiến trúc & OOP
* ◦ Thiết kế lớp Product với đầy đủ encapsulation (private fields, getter/r/setter,r,constructors)
* ◦ Sử dụng ArrayList<Product> để quản lý danh sách
* • Xử lý ngoại lệ - Exception
* ◦ Xây dựng Custom Exception: InvalidProductException
* ◦ Ném ngoại lệ này khi: Thêm trùng ID, hoặc cập nhật sản phẩm không tồn tại
* • Thao tác dữ liệu với Java 8 Stream◦ Thêm mới (Create): Kiểm tra trùng ID trước khi thêm
* ◦ Hiển thị (Read): Xuất danh sách sản phẩm theo định dạng bảng
* ◦ Cập nhật (Update): Tìm theo ID và cập nhật số lượng. Sử dụng Optional để xử lý kết quả thì tìm kiếm
* ◦ Xóa (Delete): Xóa các sản phẩm có quantity = 0
* */

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private String category;

    public Product(String id, String name, double price, int quantity, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    @Override
    public String toString() {
        return String.format("%-10s %-20s %10.2f %10d", id, name, price, quantity);
    }
    public List<Product> productList = new ArrayList<Product>();
    public void addProduct(Product product){
        for (Product p : productList) {
            if (p.getId().equals(product.getId())) {
                throw new InvalidProductException("ID đã tồn tại, không thể thêm sản phẩm.");
            }
        }
        productList.add(product);
    }
    public void getAllProducts(){
        System.out.printf("%-10s %-20s %10s %10s\n", "ID", "Name", "Price", "Quantity");
        for (Product p : productList) {
            System.out.println(p);
        }
    }
    public void updateProductQuantity(String id, int newQuantity){
        //Cập nhật (Update): Tìm theo ID và cập nhật số lượng. Sử dụng Optional để xử lý kếtquả tìtìm kiếm
        boolean found = false;
        for (Product p : productList) {
            if (p.getId().equals(id)) {
                p.setQuantity(newQuantity);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new InvalidProductException("Không tìm thấy sản phẩm với ID: " + id);
        }
    }


}

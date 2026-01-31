/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2280602734phanvansieu;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
/**
 *
 * @author sieup
 */
public class Phanvansieu {
    
/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    List<Book> listBook = new ArrayList<>();
        Scanner x = new Scanner(System.in);

        String msg = """
                -------------------------------
                Chuong trinh quan ly sach
                1. Them 1 cuon sach
                2. Xoa 1 cuon sach
                3. Thay doi sach
                4. Xuat thong tin
                5. Tim sach lap trinh
                6. Lay sach toi da theo gia
                7. Tim kiem theo tac gia
                0. Thoat
                Chon chuc nang:
                -------------------------------
                """;

        int chon = 0;

        do {
            System.out.print(msg);
            chon = x.nextInt();

            switch (chon) {
                case 1 -> {
                    Book newBook = new Book();
                    newBook.input();
                    listBook.add(newBook);
                }

                case 2 -> {
                    System.out.print("Nhap vao ma sach can xoa: ");
                    int bookId = x.nextInt();

                    Book find = listBook.stream()
                            .filter(p -> p.getId() == bookId)
                            .findFirst()
                            .orElseThrow();

                    listBook.remove(find);
                    System.out.println("Da xoa sach thanh cong");
                }

                case 3 -> {
                    System.out.print("Nhap vao ma sach can dieu chinh: ");
                    int bookId = x.nextInt();

                    Book find = listBook.stream()
                            .filter(p -> p.getId() == bookId)
                            .findFirst()
                            .orElseThrow();

                    find.input();
                }

                case 4 -> {
                    System.out.println("\nXuat thong tin danh sach:");
                    listBook.forEach(p -> p.output());
                }
                
                case 5 -> {
                    List<Book> list5 = listBook.stream()
                            .filter(u -> u.getTitle().toLowerCase().contains("lập trình"))
                            .toList();
                    list5.forEach(Book::output);
                }
                
                case 6 -> {
                    System.out.print("Nhap gia toi thieu: ");
                    double minPrice = x.nextDouble();

                    System.out.print("Nhap so luong sach can lay: ");
                    int n = x.nextInt();

                    listBook.stream()
                            .filter(b -> b.getPrice() >= minPrice)
                            .sorted(Comparator.comparingDouble(Book::getPrice).reversed())
                            .limit(n)
                            .forEach(Book::output);
                }
                
                case 7 -> {
                    x.nextLine();

                    System.out.print("Nhap so luong tac gia can tim: ");
                    int n = Integer.parseInt(x.nextLine());

                    Set<String> authorSet = new HashSet<>();

                    for (int i = 0; i < n; i++) {
                        System.out.print("Nhap ten tac gia thu " + (i + 1) + ": ");
                        authorSet.add(x.nextLine().toLowerCase());
                    }

                    listBook.stream()
                            .filter(b -> authorSet.contains(b.getAuthor().toLowerCase()))
                            .forEach(Book::output);
                }
            }
        } while (chon != 0);
    }
}

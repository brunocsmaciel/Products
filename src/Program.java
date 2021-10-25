import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

        List<Product> products = new ArrayList<>();

        System.out.println("Enter the number of products");
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            System.out.println("Product # " + (i+1) + " data: ");
            System.out.println("Common, used or imported (c/u/i)? ");
            char option = sc.next().charAt(0);
            System.out.print("Enter product name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Enter product price: ");
            Double price = sc.nextDouble();
            if(option == 'c'){
                products.add(new Product(name, price));
            }
            else if(option == 'i'){
                System.out.print("Enter customs fee: ");
                Double customsFee = sc.nextDouble();
                products.add(new ImportedProduct(name, price, customsFee));
            }
            else if(option == 'u'){
                System.out.print("Enter manufacture date: (dd/mm/yyyy)");
                Date date = sdf.parse(sc.next());
                products.add(new UsedProduct(name, price, date));
            }
            System.out.println();
        }
        System.out.println("Price Tags: ");
        products.forEach(product -> System.out.println(product.priceTag()));

        sc.close();
    }
}

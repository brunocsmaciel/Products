import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {


    private Date manufactureDate;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

    public UsedProduct(String name, Double price, Date manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag() {
        return super.priceTag()
                + " (Manufacture Date: " + sdf.format(manufactureDate) + ")";
    }

}

public class ImportedProduct extends Product {

    private Double customsFee;

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    @Override
    public String priceTag() {
        return super.getName() + " "
                + String.format("%.2f", totalPrice())
                + String.format(" (customs fee: %.2f)", customsFee);
    }

    public Double totalPrice(){
        return getPrice() + customsFee;
    }
}
package bookShop.models;

public class GoldenEditionBook extends Book {

    public GoldenEditionBook(String title, String author, double price) {
        super(title, author, price);
    }

    @Override
    protected double getPrice() {
        return super.getPrice() * 1.3d;
    }
}

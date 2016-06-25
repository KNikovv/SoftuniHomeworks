package beerCounter;

public class BeerCounter {
    static int beerInStock;
    static int beerDrank;

    BeerCounter() {

    }
    public void addBeer(int beerAmount ){
        beerInStock+=beerAmount;
    }
    public void drinkBeer(int beerAmount){
        beerDrank+=beerAmount;
        beerInStock-=beerAmount;
    }
}

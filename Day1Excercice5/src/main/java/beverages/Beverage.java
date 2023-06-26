package beverages;

import supplments.Supplement;

import java.util.ArrayList;
import java.util.List;

public class Beverage {
    double price;
    List<Supplement> supplementList = new ArrayList<Supplement>();

    public void addSupplement(Supplement sup){
        supplementList.add(sup);
        price+= sup.price();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Supplement> getSupplementList() {
        return supplementList;
    }

    public void setSupplementList(List<Supplement> supplementList) {
        this.supplementList = supplementList;
    }
}

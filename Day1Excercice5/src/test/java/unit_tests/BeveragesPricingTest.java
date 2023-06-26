package unit_tests;

import beverages.*;
import org.junit.Test;
import supplments.Cream;
import supplments.Milk;
import supplments.Supplement;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

public class BeveragesPricingTest {
    @Test
    public void shouldReturn120WhenItsCoffee() {
        Beverage coffee = new Coffee();
        assertThat(coffee.getPrice(), is(closeTo(1.20, 0.001)));
    }

    @Test
    public void shouldReturn150WhenItsTea() {
        Beverage tea = new Tea();
        assertThat(tea.getPrice(), is(closeTo(1.50, 0.001)));
    }

    @Test
    public void shouldReturn145WhenItsHotChocolate() {
        Beverage hotChocolate = new HotChocolate();
        assertThat(hotChocolate.getPrice(), is(closeTo(1.45, 0.001)));
    }

    @Test
    public void shouldReturn160WhenItsTeaWithMilk() {
        Beverage teaWithMilk = new Tea();
        teaWithMilk.addSupplement(new Milk());
        assertThat(teaWithMilk.getPrice(), is(closeTo(1.60, 0.001)));
    }

    @Test
    public void shouldReturn130WhenItsCoffeeWithMilk() {
        Beverage coffeeWithMilk = new Coffee();
        coffeeWithMilk.addSupplement(new Milk());
        assertThat(coffeeWithMilk.getPrice(), is(closeTo(1.30, 0.001)));
    }

    @Test
    public void ShouldReturn145WhenItsCoffeeWithMilkAndCream() {
        Beverage coffeeWithMilkAndCream = new Coffee();
        coffeeWithMilkAndCream.addSupplement(new Milk());
        coffeeWithMilkAndCream.addSupplement(new Cream());
        assertThat(coffeeWithMilkAndCream.getPrice(), is(closeTo(1.45, 0.001)));
    }

    @Test
    public void shouldReturn160WhenItsHotChocolateWithCream() {
        Beverage hotChocolateWithCream = new HotChocolate();
        hotChocolateWithCream.addSupplement(new Cream());
        assertThat(hotChocolateWithCream.getPrice(),  is(closeTo(1.60, 0.001)));
    }
}

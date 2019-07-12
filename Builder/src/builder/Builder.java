/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

/**
 *
 * @author Estudiante
 */
public class Builder {

    /**
     * @param args the command line arguments
     */
    // Java code to demonstrate method chaining 
	public static void main(String[] args) {
            Waiter waiter = new Waiter();
            PizzaBuilder hawaiianPizzabuilder = new HawaiianPizzaBuilder();
            PizzaBuilder spicyPizzaBuilder = new SpicyPizzaBuilder();

            waiter.setPizzaBuilder( hawaiianPizzabuilder );
            waiter.constructPizza();
            
            Pizza pizza = waiter.getPizza();
           
            System.out.println(pizza.toString());

            
            waiter.setPizzaBuilder( spicyPizzaBuilder );
            waiter.constructPizza();
            
            Pizza pizza2 = waiter.getPizza();
            System.out.println(pizza2.toString());
            
        }

    
}
/* "Product" */
class Pizza {
    private String dough = "";
    private String sauce = "";
    private String topping = "";

    public void setDough(String dough) {
        this.dough = dough;
    }
    
    
    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }
    @Override
    public String toString() 
    { 
        return "dough = " + this.dough + ", sauce = " + this.sauce +  
                               ", topping = " + this.topping; 
    }
}

/* "Abstract Builder" */
abstract class PizzaBuilder {
    protected Pizza pizza;

    public Pizza getPizza() {
        return pizza;
    }

    public void createNewPizzaProduct() {
        pizza = new Pizza();
    }

    public abstract void buildDough();
    public abstract void buildSauce();
    public abstract void buildTopping();
}

/* "ConcreteBuilder" */
class HawaiianPizzaBuilder extends PizzaBuilder {
    @Override
    public void buildDough() {
        pizza.setDough("cross");
    }
    
    @Override
    public void buildSauce() {
        pizza.setSauce("mild");
    }

    @Override
    public void buildTopping() {
        pizza.setTopping("ham+pineapple");
    }
}

/* "ConcreteBuilder" */
class SpicyPizzaBuilder extends PizzaBuilder {
    @Override
    public void buildDough() {
        pizza.setDough("pan baked");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("hot");
    }

    @Override
    public void buildTopping() {
        pizza.setTopping("pepperoni+salami");
    }
}

/* "Director" */
class Waiter {
    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pb) {
        pizzaBuilder = pb;
    }

    public Pizza getPizza() {
        return pizzaBuilder.getPizza();
    }

    public void constructPizza() {
        pizzaBuilder.createNewPizzaProduct();
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildTopping();
    }
    
}

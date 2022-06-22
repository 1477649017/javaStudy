/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-06-22
 * Time: 15:47
 */
class Food{

}
class Fruit extends Food{

}
class Apple extends Fruit{

}
class Peach extends Fruit{

}

class EatFood<T>{
    private T food;

    public T getFood() {
        return food;
    }

    public void setFood(T food) {
        this.food = food;
    }
}
public class TestDemo2 {
    public static void func3(EatFood<? super Fruit> tmp){
        tmp.setFood(new Apple());
        tmp.setFood(new Peach());


        System.out.println(tmp.getFood());
    }
    public static void main(String[] args) {
        EatFood<Fruit> e1 = new EatFood<Fruit>();
        e1.setFood(new Fruit());
        func3(e1);

        EatFood<Food> p1 = new EatFood<Food>();
        p1.setFood(new Food());
        func3(p1);
    }

    public static void func2(EatFood<? extends Food> tmp){
        Food food = tmp.getFood();

        System.out.println(tmp.getFood());
    }


    public static void main1(String[] args) {
        EatFood<Apple> e1 = new EatFood<Apple>();
        e1.setFood(new Apple());
        func2(e1);

        EatFood<Peach> p1 = new EatFood<Peach>();
        p1.setFood(new Peach());
        func2(p1);

    }
}

import java.util.HashMap;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-07-23
 * Time: 7:08
 */
class Person{
    public String ID;

    public Person(String ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(ID, person.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }



}
public class TestDemo220723 {
    public static void main(String[] args) {
        HashMap<Integer,String> hashMap = new HashMap();
    }
    public static void main2(String[] args) {
        Person person1 = new Person("1234");
        Person person2 = new Person("1234");
        System.out.println(person1.hashCode() == person2.hashCode());
        System.out.println(person1.equals(person2));
        HashBuck<Person,String> hashBuck = new HashBuck<>();
        hashBuck.put(person1,"xiaowang");
        System.out.println(hashBuck.get(person2));
    }
    public static void main1(String[] args) {
        HashBuck hashBuck = new HashBuck();
        hashBuck.put(1,1);
        hashBuck.put(2,2);
        hashBuck.put(3,3);
        hashBuck.put(4,4);
        hashBuck.put(14,14);
        hashBuck.put(5,5);
        hashBuck.put(6,6);
        hashBuck.put(7,7);
        hashBuck.put(8,8);
        System.out.println(hashBuck.get(4));
    }
}

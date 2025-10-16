class Person implements Cloneable {
    String name;
    Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // shallow copy
    }

    public void display() {
        System.out.println("Name: " + name + ", City: " + address.city);
    }
}

class Address {
    String city;

    public Address(String city) {
        this.city = city;
    }
}

public class PP4_CloningDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address addr = new Address("Chennai");
        Person p1 = new Person("Nishchay", addr);
        Person p2 = (Person) p1.clone();

        p2.name = "Ravi";
        p2.address.city = "Bangalore";

        p1.display();
        p2.display();
    }
}

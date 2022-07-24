import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;
    //...

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, OptionalInt age)  {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return getAge().isPresent();
    }
    public boolean hasAddress() {
        return !getAddress().isEmpty();
    }

    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }
    public OptionalInt getAge() {
        return this.age;
    }
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void happyBirthday() {
        if (!this.age.isPresent()) {
            this.age = OptionalInt.of(0);
        } else {
            this.age = OptionalInt.of(this.age.getAsInt() + 1);
        }
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + this.name + '\'' +
                ", surname='" + this.surname + '\'' +
                ", age=" + this.age.getAsInt() +
                ", address='" + this.address + '\'' +
                '}';
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(this.surname).setAddress(this.address);
    }
}
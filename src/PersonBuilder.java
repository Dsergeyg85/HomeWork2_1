import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;
    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (this.age >= 0) {
            this.age = age;
            return this;
        } else {
            throw new IllegalArgumentException("Возраст недопустимый");
        }
    }
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException {
        Person person;
        if (this.name != null && this.surname != null) {
            if (this.age >= 0) {
                person = new Person(this.name, this.surname, OptionalInt.of(this.age));
            } else {
                person = new Person(this.name, this.surname, OptionalInt.of(0));
            }
            if (this.address != null) {
                person.setAddress(this.address);
            }
            return person;
        } else {
            throw new IllegalStateException("Не хватает обяхательных полей");
        }
    }
}

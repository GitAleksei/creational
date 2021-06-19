package ru.netology.task1;

public class PersonBuilder implements IPersonBuilder {
    private String name;
    private String surname;
    private int age = -1;
    private String address;

    @Override
    public IPersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public IPersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    @Override
    public IPersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age less then 0");
        } else if (age > 120) {
            throw new IllegalArgumentException("Age more then 120");
        }
        this.age = age;
        return this;
    }

    @Override
    public IPersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public Person build() {
        if (name == null) {
            throw new IllegalStateException("Name not declared");
        } else if (surname == null) {
            throw new IllegalStateException("Surname not declared");
        }
        return new Person(name, surname, age, address);
    }
}

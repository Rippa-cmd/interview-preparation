package ru.geekbrains;

public class Person {

    private String firstName;

    private String lastName;

    private String middleName;

    private String country;

    private String address;

    private String phone;

    private int age;

    private String gender;

    private Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public PersonBuilder createBuilder() {
        return new PersonBuilder();
    }

    public static class PersonBuilder {

        private Person person;

        private PersonBuilder() {
            this.person = new Person();
        }

        public PersonBuilder witFirstName(String firstName) {
            person.firstName = firstName;
            return this;
        }

        public PersonBuilder witLastName(String lastName) {
            person.lastName = lastName;
            return this;
        }

        public PersonBuilder witMiddleName(String middleName) {
            person.middleName = middleName;
            return this;
        }

        public PersonBuilder witCountry(String country) {
            person.country = country;
            return this;
        }

        public PersonBuilder witAddress(String address) {
            person.address = address;
            return this;
        }

        public PersonBuilder witPhone(String phone) {
            person.phone = phone;
            return this;
        }

        public PersonBuilder witAge(int age) {
            person.age = age;
            return this;
        }

        public PersonBuilder witGender(String gender) {
            person.gender = gender;
            return this;
        }

        public Person create() {
            return this.person;
        }
    }
}

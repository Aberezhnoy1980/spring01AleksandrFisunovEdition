package ru.aberezhnoy.homework01;


public class Person {

    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    public String getFirstName() { return firstName;}
    public String getLastName() {return lastName;}
    public String getMiddleName() {return middleName;}
    public String getCountry() {return country;}
    public String getAddress() {return address;}
    public String getPhone() {return phone;}
    public int getAge() {return age;}
    public String getGender() {return gender;}

    private Person(){}

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private final Person person = new Person();

        private Builder(){}

        public Builder firstName (String firstName){
            person.firstName=firstName;
            return this;
        }

        public Builder lastName (String lastName){
            person.lastName=lastName;
            return this;
        }

        public Builder middleName (String middleName){
            person.middleName=middleName;
            return this;
        }

        public Builder country (String country){
            person.country=country;
            return this;
        }

        public Builder address (String address){
            person.address=address;
            return this;
        }

        public Builder phone (String phone){
            person.phone=phone;
            return this;
        }

        public Builder age (int age){
            person.age=age;
            return this;
        }

        public Builder gender (String gender){
            person.gender=gender;
            return this;
        }

        public Person build(){
            return person;
        }

    }

}

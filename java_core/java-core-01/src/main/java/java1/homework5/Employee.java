package java1.homework5;

public class Employee {
    private String name;
    private String position;
    private String email;
    private Long phoneNumber;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, Long phoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public String getName (){
        return name;
    }
    public String getPosition (){
        return position;
    }

    public String getEmail () {
        return email;
    }

    public Long getPhoneNumber () {
        return phoneNumber;
    }

    public int getSalary () {
        return salary;
    }

    public int getAge () {
        return age;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setPosition (String position) {
        this.position = position;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSalary (int salary) {
        this.salary = salary;
    }

    public void setAge (int age) {
        this.age = age;
    }

    public void personInfo () {
//        System.out.println (name + ", " + position +  ", " + email +  ", " + phoneNumber +  ", " + salary +  ", " + age);
        System.out.printf ("name: %s. position: %s. email: %s. phone: %d. salary: %d. age: %d. \n", name, position, email, phoneNumber, salary, age);
    }

    public String toString () {
        return (name + " " + position + " " + email + " " + phoneNumber + " " + salary + " " + age + "\n");
    }


}

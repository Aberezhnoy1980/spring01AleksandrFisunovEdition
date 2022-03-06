package java1.homework5;

import java.util.Arrays;

public class MainApp {
    public static void main (String[] args) {

        Employee[] staff = new Employee[5];
        staff[0] = new Employee ("Ivan", "Doctor", "ivan@mail.com", 89127654383l, 50000, 39);
        staff[1] = new Employee ("Alex", "Engineer", "Alex@mail.com", 89354826741l, 60000, 41);
        staff[2] = new Employee ("Sergey", "PoliceOfficer", "Sergey@mail.com", 89578376221l, 45000,35);
        staff[3] = new Employee ("Andrey", "Manager", "Andrey@mail.com", 89672547121l, 80000,44);
        staff[4] = new Employee ("Oleg", "Economist", "Oleg@mail.com", 89468667228l, 70000, 42);

        Employee[] personnel = {new Employee("Ivan", "Doctor", "ivan@mail.com", 89127654383l, 50000, 39),
                new Employee("Alex", "Engineer", "Alex@mail.com", 89354826741l, 60000, 41),
                new Employee("Sergey", "PoliceOfficer", "Sergey@mail.com", 89578376221l, 45000, 35),
                new Employee("Andrey", "Manager", "Andrey@mail.com", 89672547121l, 80000, 44),
                new Employee("Oleg", "Economist", "Oleg@mail.com", 89468667228l, 70000, 42),
        };

        System.out.println(Arrays.toString(personnel));

        System.out.println("Staff list");
        System.out.println();
        for (int i = 0; i <personnel.length; i++) {
            personnel[i].personInfo();
        }

        System.out.println();
        System.out.println("Persons over 40 years old");
        System.out.println();

        for (Employee e: staff) {
            if (e.getAge() > 40) {
                e.personInfo();
            }
        }
//        System.out.println("No person over 40 years old");
    }
}

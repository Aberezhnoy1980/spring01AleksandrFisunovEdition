package ru.aberezhnoy.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "male")
    private String male;

    @Column(name = "age")
    private int age;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private int phone;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(Long id, String name, String male, int age, String email, int phone) {
        this.id = id;
        this.name = name;
        this.male = male;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o.getClass().isInstance(this.getClass()))) return false;
        User anotherUser = (User) o;
        return this.getId().equals(anotherUser.getId())
                && this.getName().equals(anotherUser.getName())
                && this.getMale().equals(anotherUser.getMale())
                && this.getAge() == anotherUser.getAge()
                && this.getEmail().equals(anotherUser.getEmail())
                && this.getPhone() == anotherUser.getPhone()
                && this.getRoles().equals(anotherUser.getRoles());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getMale(), getAge(), getEmail(), getPhone(), roles);
    }

    @Override
    public String toString() {
        return String.format("id: %d, name: %s, male: %s, age: %d, email: %s, phone: %d\n", id, name, male, age, email, phone);
    }
}











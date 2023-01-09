package ru.aberezhnoy.dto;

import ru.aberezhnoy.model.Role;
import ru.aberezhnoy.model.User;

import java.util.Objects;
import java.util.Set;

public class UserDto {

    private Long id;

    private String name;

    private String male;

    private int age;

    private String email;

    private int phone;

    private Set<Role> roles;

    public UserDto() {
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.age = user.getAge();
        this.male = user.getMale();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.roles = user.getRoles();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!o.getClass().isInstance(this.getClass())) return false;
        UserDto dto = (UserDto) o;
        return this.getId().equals(dto.getId())
                && this.getName().equals(dto.getName())
                && this.getMale().equals(dto.getMale())
                && this.getAge() == dto.getAge()
                && this.getEmail().equals(dto.getEmail())
                && this.getPhone() == dto.getPhone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getMale(), getAge(), getEmail(), getPhone());
    }

    @Override
    public String toString() {
        return String.format("id: %d, name: %s, male: %s, age: %d, email: %s, phone: %d\n", id, name, male, age, email, phone);
    }
}

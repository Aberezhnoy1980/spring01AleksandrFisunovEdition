package ru.aberezhnoy.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role() {
    }

    public Role(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<User> getUser() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!o.getClass().isInstance(this.getClass())) return false;
        Role anotherRole = (Role) o;
        return this.getId().equals(anotherRole.getId())
                && this.getTitle().equals(anotherRole.getTitle())
                && this.getUser().equals(anotherRole.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getUser());
    }

    @Override
    public String toString() {
        return String.format("id: %d, title: %s\n", id, title);
    }
}

package ru.aberezhnoy.dto;

import ru.aberezhnoy.model.Role;

import java.util.Objects;

public class RoleDto {

    private Long id;

    private String title;

    public RoleDto() {
    }

    public RoleDto(Role role) {
        this.id = role.getId();
        this.title = role.getTitle();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!o.getClass().isInstance(this.getClass())) return false;
        RoleDto dto = (RoleDto) o;
        return this.getId().equals(dto.getId())
                && this.getTitle().equals(dto.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle());
    }

    @Override
    public String toString() {
        return String.format("id: %d, title: %s\n", id, title);
    }
}

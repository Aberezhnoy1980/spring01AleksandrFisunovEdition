package ru.aberezhnoy.converters;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import ru.aberezhnoy.dtos.PageDto;

@Component
public class PageConverter {
    public <E> PageDto<E> entityToDto(Page<E> p) {
        return new PageDto<>(p.getContent(), p.getNumber(), p.getTotalPages(), p.getTotalElements(), p.getNumberOfElements(), p.getSize());
    }
}
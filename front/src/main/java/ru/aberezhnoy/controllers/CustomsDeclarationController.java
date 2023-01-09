package ru.aberezhnoy.controllers;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import ru.aberezhnoy.dtos.CustomsDeclarationRequest;
import ru.aberezhnoy.dtos.CustomsDeclarationResponse;
import ru.aberezhnoy.dtos.PageDto;

import java.util.UUID;

public interface CustomsDeclarationController {

    PageDto<CustomsDeclarationResponse> getAllCustomsDeclaration(Integer page, Integer pageSize, String sortBy, String numberPart);

    CustomsDeclarationResponse getCustomsDeclarationById(UUID id);

    ResponseEntity<UUID> addNewCustomsDeclaration(CustomsDeclarationRequest customsDeclarationRequest);

    ResponseEntity<String> deleteCustomsDeclarationById(UUID id);

    ResponseEntity<InputStreamResource> exportCustomsDeclarations(String vatCode);
}

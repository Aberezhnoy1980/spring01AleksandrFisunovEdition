package ru.aberezhnoy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aberezhnoy.dto.ProductDto;
import ru.aberezhnoy.exception.ResourceNotFoundException;
import ru.aberezhnoy.model.Category;
import ru.aberezhnoy.model.Product;
import ru.aberezhnoy.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final CategoryService categoryService;

    @Override
    public Page<Product> findAll(int pageIndex, int pageSize) {
        return productRepository.findAll(PageRequest.of(pageIndex, pageSize));
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findWithFilter(Integer minPrice, Integer maxPrice) {
        if (minPrice != null && maxPrice == null)
            return productRepository.findProductsByPriceGreaterThan(minPrice);

        else if (minPrice == null && maxPrice != null)
            return productRepository.findProductsByPriceLessThan(maxPrice);

        else if (minPrice != null)
            return productRepository.findProductsByPriceBetween(minPrice, maxPrice);

        return productRepository.findAll();
    }

    @Override
    @Transactional
    public void updateProductFromDto(ProductDto productDto) {
        Product product = findById(productDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Product id = " +
                        productDto.getId() +
                        " not found"));
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        if (!product.getCategory().getTitle().equals(productDto.getCategoryTitle())) {
            Category category = categoryService
                    .findByTitle(productDto
                            .getCategoryTitle())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Category title = " +
                                    productDto.getCategoryTitle() +
                                    " not found"));
            product.setCategory(category);
        }
    }
}


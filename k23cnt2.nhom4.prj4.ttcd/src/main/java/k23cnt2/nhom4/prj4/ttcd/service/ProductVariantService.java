package k23cnt2.nhom4.prj4.ttcd.service;

import k23cnt2.nhom4.prj4.ttcd.entity.ProductVariant;
import k23cnt2.nhom4.prj4.ttcd.repository.ProductVariantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductVariantService {

    private final ProductVariantRepository repository;

    public ProductVariantService(ProductVariantRepository repository) {
        this.repository = repository;
    }

    public List<ProductVariant> getAll() {
        return repository.findAll();
    }

    public List<ProductVariant> getByProduct(Integer productId) {
        return repository.findByProductId(productId);
    }

    public ProductVariant save(ProductVariant variant) {
        return repository.save(variant);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
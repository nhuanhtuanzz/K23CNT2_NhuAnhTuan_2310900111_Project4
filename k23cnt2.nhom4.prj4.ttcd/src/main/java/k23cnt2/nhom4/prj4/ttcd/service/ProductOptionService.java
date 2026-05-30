package k23cnt2.nhom4.prj4.ttcd.service;

import k23cnt2.nhom4.prj4.ttcd.entity.ProductOption;
import k23cnt2.nhom4.prj4.ttcd.repository.ProductOptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOptionService {

    private final ProductOptionRepository repository;

    public ProductOptionService(ProductOptionRepository repository) {
        this.repository = repository;
    }

    public List<ProductOption> getAll() {
        return repository.findAll();
    }

    public ProductOption save(ProductOption option) {
        return repository.save(option);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
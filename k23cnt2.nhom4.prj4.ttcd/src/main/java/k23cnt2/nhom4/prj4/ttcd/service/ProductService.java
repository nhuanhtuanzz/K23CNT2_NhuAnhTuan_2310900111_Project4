package k23cnt2.nhom4.prj4.ttcd.service;

import k23cnt2.nhom4.prj4.ttcd.dto.ProductDTO;
import k23cnt2.nhom4.prj4.ttcd.entity.Product;
import k23cnt2.nhom4.prj4.ttcd.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // ================= HOME =================

    public List<ProductDTO> getHomeProducts() {
        return productRepository.getProducts();
    }

    // ================= ADMIN =================

    // lấy tất cả sản phẩm
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // lấy theo id
    public Product getProductById(Integer id) {

        return productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Không tìm thấy sản phẩm"));
    }

    // thêm sản phẩm
    public Product createProduct(Product product) {

        return productRepository.save(product);
    }

    // sửa sản phẩm
    public Product updateProduct(Integer id, Product newProduct) {

        Product oldProduct = getProductById(id);

        oldProduct.setName(newProduct.getName());
        oldProduct.setSlug(newProduct.getSlug());
        oldProduct.setDescription(newProduct.getDescription());
        oldProduct.setImageUrl(newProduct.getImageUrl());
        oldProduct.setBasePrice(newProduct.getBasePrice());
        oldProduct.setIsActive(newProduct.getIsActive());
        oldProduct.setCategory(newProduct.getCategory());

        return productRepository.save(oldProduct);
    }

    // xóa sản phẩm
    public void deleteProduct(Integer id) {

        productRepository.deleteById(id);
    }
}
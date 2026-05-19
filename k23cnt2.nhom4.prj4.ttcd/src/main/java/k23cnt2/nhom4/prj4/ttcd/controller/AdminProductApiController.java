package k23cnt2.nhom4.prj4.ttcd.controller;

import k23cnt2.nhom4.prj4.ttcd.entity.Product;
import k23cnt2.nhom4.prj4.ttcd.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/products")
public class AdminProductApiController {

    @Autowired
    private ProductService productService;
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(
            @PathVariable Integer id,
            @RequestBody Product product
    ) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Integer id) {

        productService.deleteProduct(id);

        return "Xóa sản phẩm thành công!";
    }
}
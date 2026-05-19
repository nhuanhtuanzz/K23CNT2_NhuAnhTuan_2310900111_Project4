package k23cnt2.nhom4.prj4.ttcd.controller;

import k23cnt2.nhom4.prj4.ttcd.entity.Product;
import k23cnt2.nhom4.prj4.ttcd.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/admin/products")
    public String productsPage(Model model) {

        List<Product> products = productService.getAllProducts();

        model.addAttribute("products", products);

        return "Admin/admin-products";
    }
}
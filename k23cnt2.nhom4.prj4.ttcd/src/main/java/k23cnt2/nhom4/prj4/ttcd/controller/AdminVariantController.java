package k23cnt2.nhom4.prj4.ttcd.controller;

import k23cnt2.nhom4.prj4.ttcd.service.ProductService;
import k23cnt2.nhom4.prj4.ttcd.service.ProductVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminVariantController {

    @Autowired
    private ProductVariantService variantService;

    @Autowired
    private ProductService productService;

    @GetMapping("/admin/variants")
    public String page(Model model){

        model.addAttribute(
                "variants",
                variantService.getAll()
        );

        model.addAttribute(
                "products",
                productService.getAllProducts()
        );

        return "Admin/admin-variants";
    }
}
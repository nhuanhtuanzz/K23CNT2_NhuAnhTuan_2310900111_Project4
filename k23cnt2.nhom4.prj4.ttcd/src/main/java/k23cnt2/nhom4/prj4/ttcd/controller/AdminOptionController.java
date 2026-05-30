package k23cnt2.nhom4.prj4.ttcd.controller;

import k23cnt2.nhom4.prj4.ttcd.service.ProductOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminOptionController {

    @Autowired
    private ProductOptionService optionService;

    @GetMapping("/admin/options")
    public String page(Model model){

        model.addAttribute(
                "options",
                optionService.getAll()
        );

        return "Admin/admin-options";
    }
}
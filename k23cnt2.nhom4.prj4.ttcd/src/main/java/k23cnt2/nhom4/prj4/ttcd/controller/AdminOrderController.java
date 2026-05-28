package k23cnt2.nhom4.prj4.ttcd.controller;

import k23cnt2.nhom4.prj4.ttcd.entity.ENUMS;
import k23cnt2.nhom4.prj4.ttcd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/admin/orders")
    public String ordersPage(Model model) {

        model.addAttribute(
                "orders",
                orderService.getAllOrders()
        );

        model.addAttribute(
                "statuses",
                ENUMS.OrderStatus.values()
        );

        return "Admin/admin-orders";
    }
}
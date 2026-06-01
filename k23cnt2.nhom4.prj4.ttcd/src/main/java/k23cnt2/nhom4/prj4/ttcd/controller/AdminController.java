package k23cnt2.nhom4.prj4.ttcd.controller;

import k23cnt2.nhom4.prj4.ttcd.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/admin-dashboard")
    public String adminDashboard(Model model) {

        model.addAttribute(
                "stats",
                dashboardService.getStats()
        );

        model.addAttribute(
                "recentOrders",
                dashboardService.getPendingOrders()
        );

        return "Admin/admin-dashboard";
    }
}
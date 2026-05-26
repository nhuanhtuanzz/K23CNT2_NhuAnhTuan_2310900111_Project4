package k23cnt2.nhom4.prj4.ttcd.controller;

import k23cnt2.nhom4.prj4.ttcd.entity.ENUMS;
import k23cnt2.nhom4.prj4.ttcd.entity.Order;
import k23cnt2.nhom4.prj4.ttcd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/orders")
public class AdminOrderApiController {

    @Autowired
    private OrderService orderService;

    // update trạng thái
    @PutMapping("/{id}/status")
    public Order updateStatus(
            @PathVariable Long id,
            @RequestParam ENUMS.OrderStatus status
    ) {

        return orderService.updateStatus(id, status);
    }
}
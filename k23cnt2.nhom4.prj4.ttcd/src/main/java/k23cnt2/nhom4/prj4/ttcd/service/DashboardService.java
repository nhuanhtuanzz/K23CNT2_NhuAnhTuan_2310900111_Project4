package k23cnt2.nhom4.prj4.ttcd.service;

import k23cnt2.nhom4.prj4.ttcd.dto.DashboardData;
import k23cnt2.nhom4.prj4.ttcd.entity.ENUMS;
import k23cnt2.nhom4.prj4.ttcd.entity.Order;
import k23cnt2.nhom4.prj4.ttcd.repository.OrderRepository;
import k23cnt2.nhom4.prj4.ttcd.repository.ProductRepository;
import k23cnt2.nhom4.prj4.ttcd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getPendingOrders() {

        return orderRepository.findByOrderStatus(
                ENUMS.OrderStatus.PENDING
        );
    }

    public DashboardData getStats() {

        DashboardData stats =
                new DashboardData();

        stats.setTotalOrders(
                orderRepository.count()
        );

        stats.setTotalCustomers(
                userRepository.countCustomers()
        );

        stats.setTotalProducts(
                productRepository.count()
        );

        stats.setTotalRevenue(
                orderRepository.getTotalRevenue()
                        .doubleValue()
        );

        return stats;
    }
}
package k23cnt2.nhom4.prj4.ttcd.repository;

import k23cnt2.nhom4.prj4.ttcd.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository
        extends JpaRepository<Order, Long> {
}
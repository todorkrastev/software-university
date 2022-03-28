package exam.repository;

import exam.model.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
    boolean existsByMacAddress(String macAddress);

    List<Laptop> findAllByOrderByCpuSpeedDescRamDescStorageDescMacAddressAsc();
}

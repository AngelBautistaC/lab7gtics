package com.example.lab7gtics.repository;

import com.example.lab7gtics.entity.Pago;
import com.example.lab7gtics.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
    @Query(value = "SELECT * FROM pagos p inner join usuarios u on u.id=p.id ;", nativeQuery = true)
    List<Pago> listaPagos();
}

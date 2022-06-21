package com.leverx.supplierbootapp.repository;

import com.leverx.supplierbootapp.entity.Recipient;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RecipientRepository extends CrudRepository<Recipient, Long> {

    @Query("SELECT * " +
            "FROM \"recipient\" \"r\" JOIN \"supplier_recipient\" \"sr\" ON \"r\".\"id\" = \"sr\".\"recipient_id\" " +
            "LEFT JOIN \"address\" \"a\" ON \"a\".\"tenant_id\" = \"sr\".\"recipient_id\" " +
            "WHERE \"sr\".\"supplier_id\" = :supplierId")
    List<Recipient> findAllBySupplierId(@Param("supplierId") Long supplierId);

}

package com.leverx.supplierbootapp.repository;

import com.leverx.supplierbootapp.entity.Recipient;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipientRepository extends CrudRepository<Recipient, Long> {

    @Query("SELECT R.ID AS ID, R.NAME AS NAME, R.ADDRESS_ID AS ADDRESS_ID FROM RECIPIENT R JOIN SUPPLIER_RECIPIENT SR ON R.ID = SR.RECIPIENT_ID " +
           "WHERE SR.SUPPLIER_ID = :supplierId")
    List<Recipient> findAllBySupplierId(@Param("supplierId") Long supplierId);

}
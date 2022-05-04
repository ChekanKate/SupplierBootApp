package com.leverx.supplierbootapp.repository;

import com.leverx.supplierbootapp.entity.Recipient;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RecipientRepository extends CrudRepository<Recipient, Long> {

//    @Query("SELECT R.ID AS ID, R.NAME AS NAME, A.ADDRESS_ID AS A_ADDRESS_ID, A.CITY AS A_CITY, " +
//           "A.STREET AS A_STREET, A.COUNTRY AS A_COUNTRY, A.BUILDING AS A_BUILDING " +
//           "FROM RECIPIENT R JOIN SUPPLIER_RECIPIENT SR ON R.ID = SR.RECIPIENT_ID " +
//           "LEFT OUTER JOIN ADDRESS A ON A.TENANT_ID = R.ID " +
//           "WHERE SR.SUPPLIER_ID = :supplierId")

    @Query("SELECT * " +
            "FROM RECIPIENT R JOIN SUPPLIER_RECIPIENT SR ON R.ID = SR.RECIPIENT_ID " +
            "LEFT JOIN ADDRESS A ON A.TENANT_ID = SR.RECIPIENT_ID " +
            "WHERE SR.SUPPLIER_ID = :supplierId")
    List<Recipient> findAllBySupplierId(@Param("supplierId") Long supplierId);

}

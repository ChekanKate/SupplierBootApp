package com.leverx.supplierbootapp.repository;

import com.leverx.supplierbootapp.entity.Supplier;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Long> {

//    @Query("SELECT supplier.id AS id, supplier.name AS name, address.id AS address_id, address.city AS " +
//            "address_city, address.street AS address_street, address.country AS address_country, address.building AS " +
//            "address_building FROM supplier LEFT OUTER JOIN address address ON address.id = supplier.address_id " +
//            "WHERE supplier.id = :id")
//    @Modifying
//    @Query("SELECT S.ID AS ID, S.NAME AS NAME, SR.RECIPIENT_ID AS RECIPIENT_ID, R.NAME " +
//            "FROM SUPPLIER S " +
//            "JOIN SUPPLIER_RECIPIENT SR ON (S.ID = SR.SUPPLIER_ID) " +
//            "JOIN RECIPIENT R ON (SR.RECIPIENT_ID = R.ID) " +
//            "WHERE S.ID = :id")
//    @Query("SELECT S.ID AS ID, S.NAME AS NAME FROM SUPPLIER S WHERE S.ID = :id")
//    @Query("SELECT \"S\".\"ID\" AS ID, \"S\".\"NAME\" AS NAME, \"SR\".\"RECIPIENT_ID\" AS RECIPIENT_ID, \"R\".\"NAME\" FROM \"SUPPLIER\" \"S\" \n" +
//            "JOIN \"SUPPLIER_RECIPIENT\" \"SR\" ON (\"S\".\"ID\" = \"SR\".\"SUPPLIER_ID\") JOIN \"RECIPIENT\" \"R\" ON (\"SR\".\"RECIPIENT_ID\" = \"R\".\"ID\") \n" +
//            "WHERE \"S\".\"ID\" = :id")
//    @Query("SELECT * FROM SUPPLIER S " +
//            "JOIN SUPPLIER_RECIPIENT SR ON (S.ID = SR.SUPPLIER_ID) JOIN RECIPIENT R ON (SR.RECIPIENT_ID = R.ID) " +
//            "WHERE S.ID = :id")
//    public Optional<Supplier> findById(@Param("id") Long id);

//        @Query("SELECT * FROM SUPPLIER S " +
//            "INNER JOIN SUPPLIER_RECIPIENT SR ON S.ID = SR.SUPPLIER_ID INNER JOIN RECIPIENT R ON SR.RECIPIENT_ID = R.ID " +
//            "WHERE S.ID = :id")
//    Optional<Supplier> findById(@Param("id") Long id);

//    @Query("SELECT * FROM SUPPLIER S INNER JOIN SUPPLIER_RECIPIENT SR ON (S.ID = SR.SUPPLIER_ID) INNER JOIN RECIPIENT R ON (R.ID = SR.RECIPIENT_ID)")
//    @Query("SELECT * FROM SUPPLIER")
//    List<Supplier> findAll();

}

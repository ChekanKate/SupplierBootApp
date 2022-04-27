package com.leverx.supplierbootapp.service;

import com.leverx.supplierbootapp.entity.Recipient;
import com.leverx.supplierbootapp.entity.Supplier;
import com.leverx.supplierbootapp.repository.RecipientRepository;
import com.leverx.supplierbootapp.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private SupplierRepository supplierRepository;
    private RecipientRepository recipientRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository, RecipientRepository recipientRepository) {
        this.supplierRepository = supplierRepository;
        this.recipientRepository = recipientRepository;
    }

    public Supplier findSupplierById(Long id) {
        Supplier supplier = supplierRepository.findById(id).orElse(null);
        if(supplier != null) {
            Set<Recipient> recipients = new HashSet<>();
            recipients.addAll(recipientRepository.findAllBySupplierId(id));
            supplier.setRecipients(recipients);
        }
        return supplier;
    }

    public void deleteSupplierById(Long id) {
        supplierRepository.deleteById(id);
    }

    public Supplier saveOrUpdateSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public List<Supplier> findAllSuppliers() {
        return (List<Supplier>) supplierRepository.findAll();
    }



}

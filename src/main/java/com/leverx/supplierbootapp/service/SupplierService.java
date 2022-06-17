package com.leverx.supplierbootapp.service;

import com.leverx.supplierbootapp.entity.Recipient;
import com.leverx.supplierbootapp.entity.Supplier;
import com.leverx.supplierbootapp.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;
    private final RecipientService recipientService;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository, RecipientService recipientService) {
        this.supplierRepository = supplierRepository;
        this.recipientService = recipientService;
    }

    public Supplier findSupplierById(Long id) {
        Supplier supplier = supplierRepository.findById(id).orElse(null);
        if(supplier != null) {
            Set<Recipient> recipients = new HashSet<>();
            recipients.addAll(recipientService.getRecipientsBySupplierId(id));
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
        List<Supplier> suppliers = (List<Supplier>) supplierRepository.findAll();
        for(Supplier supplier : suppliers) {
            Set<Recipient> recipients = new HashSet<>();
            recipients.addAll(recipientService.getRecipientsBySupplierId(supplier.getId()));
            supplier.setRecipients(recipients);
        }
        return suppliers;
    }

}

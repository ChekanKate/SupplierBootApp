package com.leverx.supplierbootapp.service;

import com.leverx.supplierbootapp.entity.Recipient;
import com.leverx.supplierbootapp.repository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipientService {

    private RecipientRepository recipientRepository;

    @Autowired
    public RecipientService(RecipientRepository recipientRepository) {
        this.recipientRepository = recipientRepository;
    }

    public List<Recipient> getRecipientsBySupplierId(Long id){
        List<Recipient> recipients = recipientRepository.findAllBySupplierId(id);
        return recipients;
    }

}

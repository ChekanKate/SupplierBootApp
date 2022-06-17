package com.leverx.supplierbootapp.service;

import com.leverx.supplierbootapp.entity.Address;
import com.leverx.supplierbootapp.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address findById(Long id) {
        return addressRepository.findById(id).get();
    }

    public Address saveOrUpdateAddress(Address address) {
        return addressRepository.save(address);
    }

}

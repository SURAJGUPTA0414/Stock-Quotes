package com.example.demo.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Supplier;
import com.example.demo.Repo.SupplierRepository;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id).orElse(null);
    }
}
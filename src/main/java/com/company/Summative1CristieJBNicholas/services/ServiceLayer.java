package com.company.Summative1CristieJBNicholas.services;

import com.company.Summative1CristieJBNicholas.models.Invoice;
import com.company.Summative1CristieJBNicholas.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceLayer {
   private InvoiceRepository repo;

    @Autowired
    public ServiceLayer(InvoiceRepository repo) {
        this.repo = repo;
    }

    public List<Invoice> getInvoice(Invoice invoice) {
        return repo.findAll();
    }
    public Invoice createInvoice(Invoice invoice) {
        return repo.save(invoice);
    }

    public void updateInvoice(Invoice invoice) {
        repo.save(invoice);
    }

    public void deleteInvoiceByID(int id) {
        repo.deleteById(id);
    }

    public Optional<Invoice> findByID(int id) {
        Optional<Invoice> customer = repo.findById(id);
        if (customer.isPresent()) return customer;
        return null;
    }

    public List<Invoice> findByLevel(String level) {

        return repo.findByLevel(level);
    }

    public List<Invoice> findByState(String state) {
        return repo.findByAddressState(state);
    }

}
}
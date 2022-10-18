//package com.company.Summative1CristieJBNicholas.services;
//
//import com.company.Summative1CristieJBNicholas.models.Invoice;
//import com.company.Summative1CristieJBNicholas.repository.InvoiceRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ServiceLayer {
//   private InvoiceRepository repo;
//
//    @Autowired
//    public ServiceLayer(InvoiceRepository repo) {
//        this.repo = repo;
//    }
//
//    public List<Invoice> getInvoice(Invoice invoice) {
//        return repo.findAll();
//    }
//    public Invoice createInvoice(Invoice invoice) {
//        return repo.save(invoice);
//    }
//
//    public void updateInvoice(Invoice invoice) {
//        repo.save(invoice);
//    }
//
//    public void deleteById(int invoice_id) {
//        repo.deleteById(invoice_id);
//    }

//    public Optional<Invoice> findByID(int id) {
//        Optional<Invoice> invoice = repo.findById(id);
//        if (invoice.isPresent()) return invoice;
//        return null;
//    }

//    public List<Invoice> findByInvoiceId(Integer invoice_id) {
//
//        return repo.findByInvoiceId(invoice_id);
//    }
//
//    public List<Invoice> findByState(String state) {
//        return repo.findByAddressState(state);
//    }
//
//    public List<Invoice> findAll() {
//    }
//
//    public void deleteInvoiceById(Integer id) {
//        repo.deleteById(id);
//    }
//}

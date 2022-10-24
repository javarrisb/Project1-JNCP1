
package com.company.Summative1CristieJBNicholas.repository;

import com.company.Summative1CristieJBNicholas.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {


//    List<Invoice> findAll(Integer invoiceId);
//    List<Invoice> findAllInvoices(Integer invoiceId);

    List<Invoice> findAll();


//     Optional<Invoice> findById(Integer invoice_id);

 //   List<Invoice> findByInvoiceId(Integer invoice_id);

  //  List<Invoice> findByAddressState(String state);

}


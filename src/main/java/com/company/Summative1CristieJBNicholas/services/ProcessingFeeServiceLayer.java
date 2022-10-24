//package com.company.Summative1CristieJBNicholas.services;
//
//import com.company.Summative1CristieJBNicholas.models.Invoice;
//import com.company.Summative1CristieJBNicholas.models.ProcessingFee;
//import com.company.Summative1CristieJBNicholas.repository.ProcessingFeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ProcessingFeeServiceLayer {
//
//    @Autowired
//    static
//    ProcessingFeeRepository processingFeeRepo;
//
//    public ProcessingFee findProcessingFee(Invoice invoice){
//        return processingFeeRepo.findByProductType(invoice.getItemType());
//    }
//    public void loadFee(){
//        processingFeeRepo.deleteAll();
//        processingFeeRepo.save(new ProcessingFee("Consoles", 15.49));
//        processingFeeRepo.save(new ProcessingFee("TShirts", 1.49));
//        processingFeeRepo.save(new ProcessingFee("Games", 1.99));
//    }
//}

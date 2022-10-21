package com.company.Summative1CristieJBNicholas.services;

import com.company.Summative1CristieJBNicholas.models.TaxRate;
import com.company.Summative1CristieJBNicholas.repository.TaxRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxServiceLayer {

    @Autowired
    static
    TaxRateRepository taxRateRepo;

    public static TaxRate findSalesTaxRateByState(String state){
        return taxRateRepo.findByState(state);
    }

    public void loadTaxRate(){
        taxRateRepo.deleteAll();
        taxRateRepo.save(new TaxRate("AL", .05));
        taxRateRepo.save(new TaxRate("AK", .06));
        taxRateRepo.save(new TaxRate("AZ", .04));
        taxRateRepo.save(new TaxRate("AR", .06));
        taxRateRepo.save(new TaxRate("CA", .06));
        taxRateRepo.save(new TaxRate("CO", .04));
        taxRateRepo.save(new TaxRate("CT", .03));
        taxRateRepo.save(new TaxRate("DE", .05));
        taxRateRepo.save(new TaxRate("FL", .06));
        taxRateRepo.save(new TaxRate("GA", .07));
        taxRateRepo.save(new TaxRate("HI", .05));
        taxRateRepo.save(new TaxRate("ID", .03));
        taxRateRepo.save(new TaxRate("IL", .05));
        taxRateRepo.save(new TaxRate("IN", .05));
        taxRateRepo.save(new TaxRate("IA", .04));
        taxRateRepo.save(new TaxRate("KS", .06));
        taxRateRepo.save(new TaxRate("KY", .04));
        taxRateRepo.save(new TaxRate("LA", .05));
        taxRateRepo.save(new TaxRate("ME", .03));
        taxRateRepo.save(new TaxRate("MD", .07));
        taxRateRepo.save(new TaxRate("MA", .05));
        taxRateRepo.save(new TaxRate("MI", .06));
        taxRateRepo.save(new TaxRate("MN", .06));
        taxRateRepo.save(new TaxRate("MS", .05));
        taxRateRepo.save(new TaxRate("MO", .03));
        taxRateRepo.save(new TaxRate("MT", .03));
        taxRateRepo.save(new TaxRate("NE", .04));
        taxRateRepo.save(new TaxRate("NV", .04));
        taxRateRepo.save(new TaxRate("NH", .06));
        taxRateRepo.save(new TaxRate("NJ", .05));
        taxRateRepo.save(new TaxRate("NM", .05));
        taxRateRepo.save(new TaxRate("NY", .06));
        taxRateRepo.save(new TaxRate("NC", .05));
        taxRateRepo.save(new TaxRate("ND", .05));
        taxRateRepo.save(new TaxRate("OH", .04));
        taxRateRepo.save(new TaxRate("OK", .04));
        taxRateRepo.save(new TaxRate("OR", .07));
        taxRateRepo.save(new TaxRate("PA", .06));
        taxRateRepo.save(new TaxRate("RI", .06));
        taxRateRepo.save(new TaxRate("SC", .06));
        taxRateRepo.save(new TaxRate("SD", .06));
        taxRateRepo.save(new TaxRate("TN", .05));
        taxRateRepo.save(new TaxRate("TX", .03));
        taxRateRepo.save(new TaxRate("UT", .04));
        taxRateRepo.save(new TaxRate("VT", .07));
        taxRateRepo.save(new TaxRate("VA", .06));
        taxRateRepo.save(new TaxRate("WA", .05));
        taxRateRepo.save(new TaxRate("WV", .05));
        taxRateRepo.save(new TaxRate("WI", .03));
        taxRateRepo.save(new TaxRate("WY", .04));
    }
}

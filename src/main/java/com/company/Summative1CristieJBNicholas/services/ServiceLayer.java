//package com.company.Summative1CristieJBNicholas.services;

import com.company.Summative1CristieJBNicholas.exception.QueryNotFoundException;
import com.company.Summative1CristieJBNicholas.models.*;
import com.company.Summative1CristieJBNicholas.repository.*;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.company.Summative1CristieJBNicholas.models.Invoice;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


//@Service
//public class ServiceLayer{

    //   ConsoleRepository consoleRepo;
//    TShirtRepository tshirtRepo;
//    GameRepository gameRepo;
//    InvoiceRepository invoiceRepo;
    //  TaxRateRepository taxRateRepo;
    // ProcessingFeeRepository processingFeeRepo;

    //  int availableAmount;
    // int updatedAmount;



    //   @Autowired
    // public ServiceLayer(ConsoleRepository consoleRepo,
    //                     TShirtRepository tshirtRepo, GameRepository gameRepo, InvoiceRepository invoiceRepo,
    //                      TaxRateRepository taxRateRepo, ProcessingFeeRepository processingFeeRepo) {
        //      this.consoleRepo = consoleRepo;
        //      this.tshirtRepo = tshirtRepo;
        //      this.gameRepo = gameRepo;
//        this.invoiceRepo = invoiceRepo;
        //     this.taxRateRepo = taxRateRepo;
        //      this.processingFeeRepo = processingFeeRepo;
        //  }
//database
    //  public void clearDatabase() {
        //     gameRepo.deleteAll();
        //     tshirtRepo.deleteAll();
        //     consoleRepo.deleteAll();
        //    invoiceRepo.deleteAll();
//  }
//Jpa search
    //   public List<TShirt> getTshirtByColor(String color){
        //      return tshirtRepo.findByColor(color);
        //  }
    //   public List<TShirt> getTshirtBySize(String size){
        //     return tshirtRepo.findBySize(size);
        //  }
    /** find by color and size or separately?? Both??*/
    //  public List<TShirt> getTshirtByColorAndSize(String color, String size){
        //      return tshirtRepo.findByColorAndSize(color, size);
        // }

//Tshirt
    // public List<TShirt> getAllTshirt(){
        //    return tshirtRepo.findAll();
        //  }
    // public Optional<TShirt> getSingleTshirt(int id) {
        //      Optional<TShirt> tshirt = tshirtRepo.findById(id);
        //      return tshirt.map(Optional::of).orElse(null);
        //  }
    //  public TShirt addTshirt(TShirt tshirt) {
        //      return tshirtRepo.save(tshirt);
        //   }

    //  public void updateTshirt(TShirt tshirt) {
        //      tshirtRepo.save(tshirt);
        //   }

  //  public void deleteTShirt(int id) {
   //     tshirtRepo.deleteById(id);
  //  }

    // Game
 //   public List<Games> getAllGames() {
 //       return gameRepo.findAll();
// }
 //   public List<Games> getGamesByStudio(String studio) {
        //       return gameRepo.findByStudio(studio);
//    }
//    public List<Games> getGamesByEsrbRating(String esrbRating, String rating) {
//        return gameRepo.findByEsrbRating(esrbRating, esrbRating);
//    }
//    public List<Games> getGamesByStudioAndEsrbRating(String esrbRating, String rating) {
//        return gameRepo.findByEsrbRating(  esrbRating);
//     /**   CHECK on this/** */
//    }
// //     return Optional.of( );  ???
//    public List<Games> findByTitle(String title) {
//        return gameRepo.findByTitle(title);
//    }
//
//    public Optional<Games> getSingleGameById(int id) {
//        return gameRepo.findById(id);
//    }
//
//    public Games addGame(Games game) {
//        return gameRepo.save(game);
//    }
//
//    public void updateGame(Games game) {
//        gameRepo.save(game);
//    }
//
//    public void deleteGame(int id) {
//        gameRepo.deleteById(id);
//    }

//    // CONSOLE CRUD OPERATIONS
//    public List<Console> getConsolesByManufacturer(String manufacturer) {
//        return consoleRepo.findByManufacturer(manufacturer);
//    }
//
//    public List<Console> getAllConsoles(){
//        return consoleRepo.findAll();
//    }
//
//    public Optional<Console> getSingleConsole(int id) {
//        return consoleRepo.findById(id);
//    }
//
//    public Console addConsole(Console console) {
//        return consoleRepo.save(console);
//    }
//
//    public void updateConsole(Console console) {
//        consoleRepo.save(console);
//    }
//
//    public void deleteConsole(int id) {
//        consoleRepo.deleteById(id);
//    }



// Invoice--------- CRUD but We Do not need to update/delete!! -------------

//    public List<Invoice> findAllInvoices() {
//        return invoiceRepo.findAll();
//    }
//
//    public Optional<Invoice> findById(int id) throws QueryNotFoundException {
//        if (invoiceRepo.findById(id).orElse(null) == null) {
//            throw new QueryNotFoundException("Invoice with that ID does not exist.");
//        }
//        return invoiceRepo.findById(id);
//    }
//
//    public Invoice createInvoice(Invoice invoice) {

//        Invoice updatedInvoice = invoice;
//        double salesTax = applyTaxRate(invoice);
//        double processingFee = applyProcessingFee(invoice);
//        double subtotal = calculateSubtotal(invoice);
//        double total = calculateTotal(subtotal, processingFee, salesTax);
//
//        updatedInvoice.setTax(salesTax);
////        updatedInvoice.setProceesingFee(processingFee);
//        updatedInvoice.setSubtotal(subtotal);
//        updatedInvoice.setTotal(total);
//
//        /**changed this. */
//        decreaseItemQuantity(updatedInvoice);
//            return invoiceRepo.save(updatedInvoice);
//    }
//
//    public double formatDouble(double dbl) {
//        return Double.parseDouble(String.format("%, .2f", dbl));
//    }
//
//    public double applyTaxRate(Invoice invoice) {
////        double priceBeforeTax = invoice.getQuantity() * invoice.getUnitPrice();
//        double taxRate = taxRateRepo.findByState(invoice.getState()).getRate();
//            return formatDouble(priceBeforeTax * taxRate);
//    }
//
//     public double applyProcessingFee(Invoice invoice){
////        double processingFee = processingFeeRepo.findByProductType(invoice.getItemType()).getFee();
//        if (invoice.getQuantity() >=10 ){
//            processingFee += 15.49;
//        }
//        return  formatDouble(processingFee);
//    }
//
//    public double calculateTotal(double subtotal, double processingFee, double salesTax) {
//        return formatDouble(subtotal + processingFee + salesTax);
//    }

//     public double calculateSubtotal(Invoice invoice) {
//        return formatDouble(invoice.getQuantity() * invoice.getUnitPrice());
//    }
//
//    public int checkQuantity(int requestedAmount, int availableAmount) {
//        if (availableAmount >= requestedAmount) {
//            return availableAmount - requestedAmount;
//        } else {
//            throw new DataIntegrityViolationException("Sorry, item is currently out of stock.");
//        }
//    }

//    public int getItemQuantity(Invoice invoice) {
//        int itemId = invoice.getItemId();
//
//        switch (invoice.getItemType()) {
//            case "Games" :
//                return getSingleGameById(itemId).get().getQuantity();
//            case "T-shirts" :
//                return getSingleTshirt(itemId).get().getQuantity();
//            case "Consoles" :
//                return getSingleConsole(itemId).get().getQuantity();
//            default:
//                return -1;
//        }
////    }
//    @Transactional
//    public void decreaseItemQuantity(Invoice invoice) {
//
//        int requestedAmount = invoice.getQuantity();

//        switch (invoice.getItemType()) {
//            case "Games":
//                Games game = getSingleGameById(invoice.getItemId()).get();
//                availableAmount = game.getQuantity();
//                updatedAmount = checkQuantity(requestedAmount, availableAmount);
//                game.setQuantity(updatedAmount);
//                updateGame(game);
//                break;
//            case "Consoles":
//                Console console = getSingleConsole(invoice.getItemId()).get();
//                availableAmount = console.getQuantity();
//                updatedAmount = availableAmount - requestedAmount;
//                console.setQuantity(updatedAmount);
//                updateConsole(console);
//                break;
//            case "T-shirts":
//                TShirt tshirt = getSingleTshirt(invoice.getItemId()).get();
//                availableAmount = tshirt.getQuantity();
//                updatedAmount = availableAmount - requestedAmount;
//                tshirt.setQuantity(updatedAmount);
//                updateTshirt(tshirt);
//                break;
//        }
//    }
//
//    public void findByEsrbRating(String mature) {
//    }
//}



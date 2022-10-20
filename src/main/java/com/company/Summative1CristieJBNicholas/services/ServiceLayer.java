
package com.company.Summative1CristieJBNicholas.services;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import com.company.Summative1CristieJBNicholas.models.Invoice;
import com.company.Summative1CristieJBNicholas.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceLayer {
    public InvoiceRepository repo;
    public void repo(Invoice inputInvoice) {
    }
    @Autowired
    public ServiceLayer(InvoiceRepository repo) {
        this.repo = repo;
    }
 
    public Invoice createInvoice(Invoice invoice) {
        return repo.save(invoice);
    }
    public List<Invoice> findAll() {
        return repo.findAll();
    }

    public void updateInvoice(Invoice invoice) {
        repo.save(invoice);
    }

    public Optional<Invoice> findByID(int id) {
        Optional<Invoice> invoice = repo.findById(id);
        if (invoice.isPresent()) return invoice;
        return null;
    }

//     @Transactional
//    public AlbumViewModel saveAlbum(AlbumViewModel viewModel) {
//        // write album information to the database
//        Album a = new Album();
//        a.setTitle(viewModel.getTitle());
//        Artist theNewArtist = viewModel.getArtist();
//        int theNewArtistId = theNewArtist.getId();;
//        a.setArtistId(theNewArtistId);
//        a.setLabelId(viewModel.getLabel().getId());
//        a.setReleaseDate(viewModel.getReleaseDate());
//        a.setListPrice(viewModel.getListPrice());
//
//        a = albumRepository.save(a);
//
//        // get the album id and set the album id field for each track
//        List<Track> tracks = viewModel.getTracks();
//
//        for(Track track : tracks) {
//            track.setAlbumId(a.getId());
//            // write each track to the database
//            trackRepository.save(track);
//        }
 
//}




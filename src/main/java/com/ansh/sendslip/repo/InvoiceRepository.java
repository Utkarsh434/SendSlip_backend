package com.ansh.sendslip.repo;

import com.ansh.sendslip.entity.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository extends MongoRepository<Invoice,String> {

    List<Invoice> findByClerkId(String id);
    Optional<Invoice> findByClerkIdAndId(String clerkid, String id);
}

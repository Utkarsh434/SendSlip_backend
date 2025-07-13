package com.ansh.sendslip.service;

import com.ansh.sendslip.entity.Invoice;
import com.ansh.sendslip.repo.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public Invoice saveInvoice(Invoice invoice){
        System.out.println("backend");
        System.out.println(invoice);
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> fetchInvoices(String clerkId){
        return invoiceRepository.findByClerkId(clerkId);
    }

    public void removeInvoice(String invoiceId , String clerkId){
        Invoice existingInvoice = invoiceRepository.findByClerkIdAndId(clerkId,invoiceId)
                .orElseThrow(()->new RuntimeException("Invoice not found "+invoiceId));
        invoiceRepository.delete(existingInvoice);
    }
}

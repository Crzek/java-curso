package com.baeldung.services;


import com.baeldung.model.Invoice;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
    public float calculateTax(long importe, float tax) {
        return ((100-tax)/100) * importe;
    }

//    public Invoice validateInvoice(){
//        System.out.println();
//    };
}

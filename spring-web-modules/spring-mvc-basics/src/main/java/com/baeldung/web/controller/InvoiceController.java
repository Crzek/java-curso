package com.baeldung.web.controller;


import com.baeldung.model.Invoice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class InvoiceController {


    @RequestMapping(value = "/invoice", method = RequestMethod.GET)
    public ModelAndView showForm(){
        return new ModelAndView(
                    "invoiceForm",
                    "invoice",
                    new Invoice());

    };
//    @ModelAttribute("invoice")
    @RequestMapping(value = "/invoiceResult", method = RequestMethod.POST)
    public String showResultForm(@Valid @ModelAttribute("invoice") final Invoice invoice,
                                 final BindingResult result,
                                 final ModelMap model
                                 ){
        if (result.hasErrors()){
            return "invoiceForm";
        }

        long importe = invoice.getValue();
        float tax = invoice.getPercent();

        float resultado= ((100-tax)/100) *importe;

        model.addAttribute("concept", invoice.getConcept());
        model.addAttribute("value", importe);
        model.addAttribute("percent", tax);
        model.addAttribute("dateInvoice", invoice.getDateInvoice());
        model.addAttribute("result", resultado);


        Invoice.addInvoiceMap(invoice);

        return "invoiceResult"; // return view
    };

    @RequestMapping(value = "/invoiceList", method = RequestMethod.GET)
    public String showAllInvoice(
            @ModelAttribute("invoice") final Invoice invoice,
            final BindingResult result,
            final ModelMap model

    ){

        model.addAttribute("invoices",Invoice.getInvoiceMap());
        return "invoiceList";
    }

}

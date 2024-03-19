package com.baeldung.web.controller;


import com.baeldung.model.Invoice;
import com.baeldung.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

@Controller
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @RequestMapping(value = "/invoice", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView(
                "invoiceForm",
                "invoice",
                new Invoice());

    }

    @RequestMapping(value = "/invoiceResult", method = RequestMethod.POST)
    public String showResultForm(
            @Valid @ModelAttribute("invoice") final Invoice invoice, // @ Validate PAra que valide los datos
            final BindingResult result,
            final ModelMap model,
            HttpSession session
    ) {
        if (result.hasErrors()) {
            return "/invoiceForm";
        }

        Integer contador = (Integer) session.getAttribute("contador");

//        int sizeMap = Invoice.getInvoiceMap().size();
//        invoice.setId(sizeMap + 1);
        if (contador == null){
           contador = 0;
        }

        contador++;
        invoice.setId(contador);
        session.setAttribute("contador",contador);

        long importe = invoice.getValue();
        float tax = invoice.getPercent();


        model.addAttribute("id", invoice.getId());
        model.addAttribute("concept", invoice.getConcept());
        model.addAttribute("value", importe);
        model.addAttribute("percent", tax);
        model.addAttribute("dateInvoice", invoice.getDateInvoice());
        model.addAttribute("result", invoiceService.calculateTax(importe, tax));

        // Aui lo guardo en un atributo Statica
        Invoice.addInvoiceMap(invoice);

        return "invoiceResult"; // return view
    }

    ;

    @RequestMapping(value = "/invoiceList", method = RequestMethod.GET)
    public String showAllInvoice(
            @ModelAttribute("invoice") final Invoice invoice,
            final BindingResult result,
            final ModelMap model

    ) {

        model.addAttribute("invoices", Invoice.getInvoiceMap());
        return "invoiceList";
    }

    @RequestMapping(value = "/invoiceDelete/{id}", method = RequestMethod.POST)
    public String deleteInvoice(@PathVariable final int id) {
        Map<Integer, Invoice> invoices = Invoice.getInvoiceMap();

//        if ((invoices.size() >= id) && (id > 0)) {
        Invoice invoiceSelect = invoices.get(id);
        Invoice.removeInvoiceMap(invoiceSelect);
//        }
        return "redirect:/invoiceList";
    }

    @RequestMapping(value = "/invoiceUpdate/{id}", method = {RequestMethod.POST, RequestMethod.GET})
    public String updateInvoice(@PathVariable final int id,
                                @ModelAttribute("invoice") final  Invoice invoice,
                                final BindingResult result,
                                final ModelMap model
                                )
    {
        Map<Integer, Invoice> invoiceMap = Invoice.getInvoiceMap();

//        if ((invoiceMap.size() >= id) && (id > 0)) {
        Invoice invoiceSelect = invoiceMap.get(id);


        model.addAttribute("id", invoiceSelect.getId());
        model.addAttribute("concept", invoiceSelect.getConcept());
        model.addAttribute("value", invoiceSelect.getValue());
        model.addAttribute("percent", invoiceSelect.getPercent());
        model.addAttribute("dateInvoice", invoiceSelect.getDateInvoice());
        model.addAttribute("result", invoiceService.calculateTax(invoiceSelect.getValue(), invoiceSelect.getPercent()));
        model.addAttribute("update", true);

        return "invoiceEdit";
//        }
//        return "redirect:/invoiceList";



    }
    @RequestMapping(value = "/invoiceResultUpdate", method = RequestMethod.POST)
    public String showResultFormUpdate (
            @Valid @ModelAttribute("invoice") final Invoice invoice, // @ Validate PAra que valide los datos
            final BindingResult result,
            final ModelMap model){

        if (result.hasErrors()) {
            return "invoiceEdit";
        }

        Map<Integer, Invoice> invoiceMap = Invoice.getInvoiceMap();

        // modificamos valores
        int idInvoice = invoice.getId();
        long importe = invoice.getValue();
        float tax = invoice.getPercent();
        invoice.setAll(
                invoice.getConcept(),
                importe,
                tax,
                invoice.getDateInvoice()
        );
        Invoice.setOnlyInvoice(idInvoice, invoice);

        model.addAttribute("id", invoice.getId());
        model.addAttribute("concept", invoice.getConcept());
        model.addAttribute("value", importe);
        model.addAttribute("percent", tax);
        model.addAttribute("dateInvoice", invoice.getDateInvoice());
        model.addAttribute("result", invoiceService.calculateTax(importe, tax));

        return "invoiceResult"; // return view

    }
//    @RequestMapping(value = "/sessionClean", method = RequestMethod.POST)
//    public String clean(HttpSession session){
//        session.invalidate();
//        return "/invoiceList";
//    }
}
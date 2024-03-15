package com.baeldung.web.controller;


import com.baeldung.model.Invoice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InvoiceController {

    @RequestMapping(value = "/invoice", method = RequestMethod.GET)
    public ModelAndView showForm(){
        return new ModelAndView(
                    "invoiceForm.jsp",
                    "invoice",
                    new Invoice());

    }

}

package com.baeldung.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Invoice {
    private int id;
    @NotBlank(message = "{invoice.e.subject}") // {} -> es una propertie
    private String concept;

    @Positive(message = "{invoice.e.value}")
    private long value;
    @Positive(message = "{invoice.e.per}")
    private float percent;
    @NotNull(message = "{invoice.e.date}")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dateInvoice;


    // uso para guardar en memoria la facturas
    static Map<Integer, Invoice> invoiceMap = new HashMap<>();


    public static void addInvoiceMap(Invoice invoice) {
        invoiceMap.put( invoice.getId(), invoice);
    }

    public static boolean removeInvoiceMap(Invoice invoice){
        invoiceMap.remove(invoice.getId());
        return true;
    }

    public static Map<Integer, Invoice> getInvoiceMap() {
        return invoiceMap;
    }

    public static void setInvoiceMap(Map<Integer, Invoice> invoiceMap) {
        Invoice.invoiceMap = invoiceMap;
    }

    public static void setOnlyInvoice(Integer id, Invoice invoice){
        invoiceMap.put(id,invoice);
    }


    public Invoice(){}
    public Invoice(String concept, long value,float percent,Date dateInvoice){
        this.concept = concept;
        this.value =value;
        this.percent = percent;
        this.dateInvoice = dateInvoice;
        System.out.println();
    }

    public void setAll(String concept,long value, float percent, Date dateInvoice){
        this.concept = concept;
        this.value = value;
        this.percent = percent;
        this.dateInvoice = dateInvoice;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "concept='" + concept + '\'' +
                ", value=" + value +
                ", percent=" + percent +
                ", dateInvoice=" + dateInvoice +
                '}';
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public Date getDateInvoice() {
        return dateInvoice;
    }

    public void setDateInvoice(Date dateInvoice) {
        this.dateInvoice = dateInvoice;
    }
}

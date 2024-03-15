package com.baeldung.model;

import java.util.Date;

public class Invoice {
    private int id;
    private String concept;

    private long value;
    private float percent;
    private Date dateInvoice;

    public Invoice(){}
    public Invoice(String concept, long value,float percent,Date dateInvoice){
        this.concept = concept;
        this.value =value;
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

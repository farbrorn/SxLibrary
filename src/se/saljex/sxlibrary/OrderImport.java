/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.saljex.sxlibrary;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author ulf
 */
public class OrderImport implements Serializable{
    private String kundnr;
    private short lagernr=0;
    
    private String marke;
    private String levAdr1;
    private String levAdr2;
    private String levAdr3;
    private ArrayList<OrderRad> orderRader = new ArrayList<OrderRad>();

    public String getKundnr() {
        return kundnr;
    }

    public void setKundnr(String kundnr) {
        this.kundnr = kundnr;
    }

    public short getLagernr() {
        return lagernr;
    }

    public void setLagernr(short lagernr) {
        this.lagernr = lagernr;
    }

    public String getLevAdr1() {
        return levAdr1;
    }
    
    public String getLevAdr1TrimedToMaxLength() {
        return (trimToMaxLength(levAdr1, 30));
    }
    public String getLevAdr2TrimedToMaxLength() {
        return (trimToMaxLength(levAdr2, 30));
    }
    public String getLevAdr3TrimedToMaxLength() {
        return (trimToMaxLength(levAdr3, 30));
    }

    public void setLevAdr1(String levAdr1) {
        this.levAdr1 = levAdr1;
    }

    public String getLevAdr2() {
        return levAdr2;
    }

    public void setLevAdr2(String levAdr2) {
        this.levAdr2 = levAdr2;
    }

    public String getLevAdr3() {
        return levAdr3;
    }

    public void setLevAdr3(String levAdr3) {
        this.levAdr3 = levAdr3;
    }

    public String getMarke() {
        return marke;
    }

    public String getMarkeTrimmedToMaxLength() {
        return trimToMaxLength(marke, 30);
    }
    
    public void setMarke(String marke) {
        this.marke = marke;
    }

    public ArrayList<OrderRad> getOrderRader() {
        return orderRader;
    }

    public void addOrderRad(String artnr, Double antal) {
        orderRader.add(new OrderRad(artnr, antal));
    }
    public void addOrderRad(String artnr, String antal) {
        orderRader.add(new OrderRad(artnr, antal));
    }
    public void addOrderRad(String artnr, String namn, Double antal) {
        orderRader.add(new OrderRad(artnr, namn, antal));
    }
    public void addOrderRad(String artnr, String namn, String antal) {
        orderRader.add(new OrderRad(artnr, namn, antal));
    }
    public void addOrderTextRad(String text) {
        orderRader.add(new OrderRad(text));
    }
    
    
    public class OrderRad implements Serializable {
        private String artnr;
        private Double antal;
        private String namn;
        private String textrad;
        
        public OrderRad() {
        }

        public OrderRad(String textrad) {
            this.artnr=null;
            this.textrad = textrad;
        }
        
        public OrderRad(String artnr, Double antal) {
            this(artnr, null, antal);
        }
        public OrderRad(String artnr, String namn, Double antal) {
            this.artnr = artnr;
            this.antal = antal;
            this.namn = namn;
        }
        public OrderRad(String artnr, String antal) {
            this(artnr, null, antal);
        }
        public OrderRad(String artnr, String namn, String antal) {
            this.artnr = artnr;
            this.namn = namn;
            setAntal(antal);
        }

        public String getArtnr() {
            return artnr;
        }
        public String getArtnrTrimmedToMaxLength() {
            return trimToMaxLength(artnr, 13);
        }

        public void setArtnr(String artnr) {
            this.artnr = artnr;
        }

        public Double getAntal() {
            return antal;
        }

        public void setAntal(Double antal) {
            this.antal = antal;
        }
        public void setAntal(String antal) {
            try {
                this.antal = new Double(antal);
            } catch (Exception e) { this.antal = 0.0; }
        }

        public String getNamn() {
            return namn;
        }
        public String getNamnTrimmedToMaxLength() {
            return trimToMaxLength(namn, 30);
        }

        public void setNamn(String namn) {
            this.namn = namn;
        }

        public String getTextrad() {
            return textrad;
        }
        public String getTextradTrimmedToMaxLength() {
            return trimToMaxLength(textrad, 60);
        }

        public void setTextrad(String textrad) {
            this.textrad = textrad;
        }
        
        
        
    }
          public static String trimToMaxLength(String s, int maxLength) {
            if (s!=null && s.length() > maxLength) return s.substring(0,maxLength); else return s;

        }
 
}

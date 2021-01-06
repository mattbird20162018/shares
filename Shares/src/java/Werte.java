/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.persistence.Transient;
import org.apache.jasper.tagplugins.jstl.core.Url;

@ManagedBean
@Entity
public class Werte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int nr;
    private String name;
    private String code;
    private int anzahl;
    private double kaufkurs;
    private double einstandswert;
    private double currentKurs;
    private double currentValue;
    private double difference;
    @OneToMany
    public List<Dividende> dividendenliste = new ArrayList<Dividende>();

    
    
    
public Werte(){}

//getter
public int getNr() {
        return nr;
    }

public String getName() {
        return name;
    }

public String getCode() {
        return code;
    }

public int getAnzahl() {
        return anzahl;
    }

public double getKaufkurs() {
        return kaufkurs;
    }

public double getEinstandswert() { 
    return einstandswert;    
    }

public double getCurrentKurs() { 
    return currentKurs;    
    }

public double getCurrentValue() { 
    return currentValue;    
    }

public double getCurrentDifference() { 
    return difference;    
    }
public List<Dividende> getDividendenliste(){
    return dividendenliste;
}

//setter
public void setNr(int nr) {
        this.nr = nr;
    }
public void setName(String name) {
        this.name = name;
    }
public void setCode(String code) {
        this.code = code;
    }
public void setAnzahl(int anzahl) {
        this.anzahl=anzahl;
    }
public void setKaufkurs(double kaufkurs) {
        this.kaufkurs = kaufkurs;
    }
public void setEinstandswert(double einstandswert) {
       this.einstandswert = einstandswert;
}
public void setCurrentKurs(double currentKurs) {
       this.currentKurs = currentKurs;
}
public void setCurrentValue(double currentValue) {
       this.currentValue = currentValue;
}
public void setDifference(double difference) {
       this.difference = difference;
}
public void setDividendenliste(List<Dividende> dividendenliste){
    this.dividendenliste = dividendenliste;
}


       
    
//other methodic
public double createEinstandswert() { 
    return this.einstandswert = this.kaufkurs * this.anzahl;
}

public double createCurrentValue() { 
    return this.currentValue = this.currentKurs * this.anzahl;
}

//Currently not in use
public double createDifference() { 
    return this.difference = this.einstandswert - this.currentValue;
}
    
//Ermittle Summe über alle Dividenden
public double divSummy() {
        int divSummy = 0;
        for(int i= 0; i< getDividendenliste().size(); i++)
        {
            divSummy += getDividendenliste().get(i).getDivid();
           
        }
        return divSummy; 
       
    } 
/*
 public double createCurrentKurs() throws MalformedURLException, IOException { 
     String code2 = getCode();
     String baseUrl = "http://api.marketstack.com/v1/eod?access_key=9f99a5a6ba488f647528b7a4a6406957&symbols=";
           URL yahoo;
            yahoo = new URL(baseUrl+code2);
           URLConnection yc = yahoo.openConnection();
           Double kurs;
           try (BufferedReader in = new BufferedReader(
           new InputStreamReader(
           yc.getInputStream()))) {
           String inputLine = in.readLine();
           int valueStart= inputLine.indexOf("close");
           int valueEnd= inputLine.indexOf("volume");
           String close = inputLine.substring(valueStart + 7, valueEnd -2);
           kurs = Double.valueOf(close);
           kurs= this.kursA;
           return this.kursA;
        
    }
    }

*/}






    

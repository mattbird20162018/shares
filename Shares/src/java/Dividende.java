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
import java.util.Date;
import java.util.List;
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

@ManagedBean
@Entity
public class Dividende implements Serializable {

	
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Id
        private int id;
        private double divid;
        
        //getter
        public int getId(){
            return this.id;
        }
        public double getDivid(){
            return divid;
        }
        //setter
        public void setId(int id){
            this.id=id;
        }
         public void setDivid(double divid){
            this.divid=divid;
        }
        
    public Dividende() {
    }
    
}

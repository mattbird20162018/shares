/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
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

@ManagedBean

   
  public class WerteController {

  private int index = 0;
  private Werte neuerWert = null;
  private Dividende neueDividende = null;
	
  
  public Werte getWerte() {
    return Verwaltung.getInstance().getAktien().get(index);
  }
  
   public void vor(){
    if (index < Verwaltung.getInstance().getAktien().size()-1)
      index++;
  }
  
  public void zurueck(){
    if (index > 0)
      index--;
  }

  public int getIndex() {
    return index;
  }

	
	public Werte getNeuerWert() {
		if(null == neuerWert) {
			this.neuerWert = new Werte();
		}
		return this.neuerWert;
	}
        public Dividende getNeueDividende() {
		if(null == neueDividende) {
			this.neueDividende = new Dividende();
		}
		return this.neueDividende;
	}
  
	public String addWert() {
		return "addWert";
	}

        public String addDividende() {
		return "addDividende";
	}
	public String abbrechen() {
		return "index";
	}
	
	public String speichern() {
		Verwaltung.getInstance().saveNeueWerte(neuerWert);
		return null;
	}
        public String speichernDividende() {
		Verwaltung.getInstance().saveDividende(neueDividende, getWerte());
                this.neueDividende =null;
		return "";
	}
}


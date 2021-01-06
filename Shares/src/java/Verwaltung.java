/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author marian.benner
 */
@ManagedBean()
@ApplicationScoped
public class Verwaltung {

	private static Verwaltung instance = new Verwaltung();
	private final static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SharesPU");
             
	public Verwaltung() { }

	public List<Werte> getAktien() {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createQuery("select a from Werte a");
		List<Werte> werte = q.getResultList();
		em.close();
		return werte;
	}
	
        
        public void saveNeueWerte(Werte neuerWert){
            EntityManager em = entityManagerFactory.createEntityManager();
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(neuerWert);
            t.commit();
            em.close();
            
        }
           public void saveDividende(Dividende neueDividende, Werte wert){
            wert.getDividendenliste().add(neueDividende);
            EntityManager em = entityManagerFactory.createEntityManager();
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(neueDividende);
            em.merge(wert);
            t.commit();
            em.close();
            
        }

	public static Verwaltung getInstance() {
		return instance;
	}

        

        
}

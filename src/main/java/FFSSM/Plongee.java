/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set; 

public class Plongee {

    public Site lieu;

    public Moniteur chefDePalanquee;

    public Calendar date;

    public int profondeur;

    public int duree;

    private HashSet plongeurs = new HashSet<Plongeur>();
    
    public Plongee(Site lieu, Moniteur chefDePalanquee, Calendar date, int profondeur, int duree) {
        this.lieu = lieu;
        this.chefDePalanquee = chefDePalanquee;
        this.date = date;
        this.profondeur = profondeur;
        this.duree = duree;
    }

    public void ajouteParticipant(Plongeur participant) {
         plongeurs.add(participant);             
      
    }

    public Calendar getDate() {
        return date;
    }

    public boolean estConforme() {
        // Parcours de la liste des plongeurs
        // Pour chaque plongeur si licence non valide, on sort de la boucle avec return false
        // quand on a parcouru toute la liste, on peut faire un return true
        Licence l = null;
        Plongeur plg = null;
        
        Iterator<Plongeur> iplg = plongeurs.iterator(); 
        while (iplg.hasNext()) {
            plg = iplg.next();
           l = plg.derniereLicence();
           if (l.estValide(this.date)== false) {
                   return false;
        }
        }
        return true;
    
    }

}

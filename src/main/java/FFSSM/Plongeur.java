package FFSSM;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Plongeur extends Personne {
    
    public int niveau;    
    private Licence licence;
    private List<Licence> licences = new ArrayList<Licence>();
    private GroupeSanguin groupe;
    
    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int niveau , Licence licence,GroupeSanguin groupe) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
        this.licence=licence;
        this.groupe=groupe;
    }
    
    
    public void ajouterLicence(Licence l){
        this.licences.add(l);
    }
    
    public Licence derniereLicence(){
        Licence last = licences.get(licences.size() - 1);
        return last;
        
    }
	
}

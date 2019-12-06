
import FFSSM.Club;
import FFSSM.Licence;
import FFSSM.Moniteur;
import FFSSM.Plongee;
import FFSSM.Plongeur;
import FFSSM.Site;
import java.util.Calendar;
import java.util.Locale;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author njacomi
 */
public class TestPlongee {
   
    Moniteur bono,bulo;
    Plongeur momo,b,martin;
    Club plongee2000,subaqua;
    Licence licence1,licence2,licence,licence3;
    Site site;
    
    @Before
	public void setUp() {
                                            
                 
            
                Calendar d = Calendar.getInstance();
                Calendar c = (Calendar)d.clone();
                c.add(Calendar.YEAR, -1);
                               
            
		 bono = new Moniteur("0120","bono","jean","x","061085",null,2365);
                 bulo = new Moniteur("1478","bulo","chloé","p","065423",null,6865);	
                 momo= new Plongeur ("0410","momo","edouard","y","210085",null,2,null,null);
                 b= new Plongeur ("1587","bitch","fred","g","102147",null,2,null,null);
                 martin= new Plongeur ("1258","martin","elise","u","103265",null,5,null,null);
                 plongee2000= new Club (bono,"plongee2000","052321");
                 subaqua= new Club (bulo,"subaqua","055214");
                 licence1= new Licence (martin,"15963",c,5,plongee2000);
                 licence3=new Licence (momo,"15963",d,5,plongee2000);
                 site = new Site("Argeles",null);
	}
        @Test
        public void testplongeesConformesOuNon(){
                Calendar k = Calendar.getInstance();
                Calendar f = (Calendar)k.clone();
                f.add(Calendar.YEAR, -1);
		Plongee plongee = new Plongee(site,bono,k,300,120);
		momo.ajouterLicence(licence3);
                plongee.ajouteParticipant(momo);
                assertTrue(plongee.estConforme());
                b.ajouterLicence(licence1);
                plongee.ajouteParticipant(b);
                assertFalse(plongee.estConforme());
                
	}
        
        @Test
        public void testestValide(){
          Calendar delivrance = Calendar.getInstance();
		licence = new Licence(null, null, delivrance, 0, null);
                assertTrue( licence.estValide(delivrance) );
                Calendar unMoisApres = (Calendar) delivrance.clone();
		unMoisApres.add(Calendar.MONTH, 1);             
		assertTrue( licence.estValide(unMoisApres) );
                Calendar unAnApres = (Calendar) delivrance.clone();
		unAnApres.add(Calendar.YEAR, 1);             
		assertFalse( licence.estValide(unAnApres) );
                
        
        }
          @Test
        public void testInvalide(){
            
            Calendar delivrance = Calendar.getInstance();
             licence2 = new Licence(null, null, delivrance, 0, null);
		Calendar d = (Calendar) delivrance.clone();
		d.add(Calendar.YEAR, 1);
		d.add(Calendar.DAY_OF_YEAR, 1);
		assertFalse( licence2.estValide(d) );
                Calendar d2 = (Calendar) delivrance.clone();
		d2.add(Calendar.DAY_OF_YEAR, -1);
		assertTrue(licence2.estValide(d2));
        }
       
}

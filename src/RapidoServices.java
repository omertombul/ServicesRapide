/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author omer
 */
import com.francis.utilisateur.utilisateur.*;
import com.francis.utilisateur.exception.*;
import com.francis.utilisateur.utilisateur.APIDB_temporaire.BDIdentifiant;
import com.omer.ServicesType.*;
import com.mathieu.baseD.*;


public class RapidoServices {
    public static Profile profile;
    public static Identifiant id;
    public static Utilisateur user;
    public static AbstraiteServices plomberie;
    public static BdApi bdConnect;
    
    
    
     public static void main(String[] args){
         float tauxHorraire = 15.0f;
         float prixFixe = 12.0f;
         byte cote = 4;
         try{
             profile = new Profile("Empror", "Mathieu", "5149999999", "e@e.com" );
             
             id = new Identifiant("usager12", "Passwo_r" );
             //plomberie = new TypeServices(tauxHorraire, prixFixe, null, true, null, cote, null, null, null );
             user = new Utilisateur(id, profile);
             System.out.println("\nConnection BD from test class");
             System.out.println("Test user: " + user.identifiant.nomUtilisateur +  " " + user.profile.nom + "\n");
             
             bdConnect = new BdApi();
             bdConnect.addUser(user);
         }catch(MyException e){
             System.out.println(e);
         }
     
     
     }
    
    
}

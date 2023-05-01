package vue;

import dao.JpaUtil;
import java.io.IOException;
import metier.service.Service;
import metier.modele.Employe;
import metier.modele.Client;
import metier.modele.Medium;
import metier.modele.Cartomancien;
import metier.modele.Spirite;
import metier.modele.Astrologue;
import metier.modele.Consultation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import metier.modele.ProfilAstral;
import util.AstroNetApi;

/* NOTES : 
    Mettre plus d'employés, ...
    Rajouter traces débuggage
    Requete trouver employe favorable
    demanderConsultation() -> Mettre employe indisponible, rajouter à l'historique de tout le monde et persister
    Faire le service de statistiques
    Faire un service de consultation de l'historique
    Demander de prédiction APIAstroNet
    Ajouter un commentaire
    SEQUENCE ?
*/



/**
 *
 * @author mnguyen
 */



public class Main {
    
    
    public static void main(String[] args) throws ParseException, IOException {
        
        JpaUtil.creerFabriquePersistance();
        
        /*Initialisation*/
        testerInitialiserEmployes();
        testerInitialiserMediums();
        
        /* Test Basiques */
        //testerTrouverEmployeParId();
        //testerListerTousEmployes();
        //testerListerTousMediums();
        
        /*Test d'inscription*/
        //testerInscriptionClient();
        
        /*Tests de connexion*/
        //testerAuthentifierEmploye();
        //testerSeDeconnecter();
        //testerAuthentifierClient();   // ATTENTION : un seul utilisateur peut être connecté à la fois
        //testerSeDeconnecter();
        
        /*Tests de services Client*/
        //testerListerTousCartomanciens();
        //testerListerTousSpirites();
        //testerListerTousAstrologues();
        //testerDemandeConsultation();
        //testerObtenirProfilAstralPourClient();
        //testerHistoriqueClient();
        
        /*Test de services Employe*/
        //testerObtenirProfilAstralDuClient();
        //testerObtenirHistoriqueDuClient();
        //testerDebuterConsultation();
        //testerTerminerConsultation();
        //testerRealiserPrediction();
        //testerLaisserCommentaire();
        //testerNbConsultationsParMedium();
        //testerNbClientsParEmploye();
        //testerTop5Medium();
        
        
        /* SCENARIO 1 */ 
        /* Trois clients s'inscrivent. L'un d'eux se connecte, liste tous les 
        cartomanciens, demande une consultation puis se déconnecte */
        
        /*testerInscriptionClient();
        testerAuthentifierClient();
        testerListerTousCartomanciens();
        testerDemandeConsultation();
        testerSeDeconnecter();*/
        
        /* SCENARIO 2 */
        /* Débute comme le scénario 1, puis un employé se connecte, consulte le
        profil astral et l'historique du client puis indique qu'il est prêt.
        Lorsqu'il reçoit l'appel du client, il n'a pas d'inspiration et demande 
        donc de l'aide. Il termine ensuite la consultation sans laisser de
        commentaire puis se déconnecte*/
        
        /*testerInscriptionClient();
        testerAuthentifierClient();
        testerListerTousCartomanciens();
        testerDemandeConsultation();
        testerSeDeconnecter();
        testerAuthentifierEmploye();
        testerObtenirProfilAstralDuClient();
        testerObtenirHistoriqueDuClient();
        testerDebuterConsultation();
        testerRealiserPrediction();
        testerTerminerConsultation();
        testerSeDeconnecter();*/
        
        
        /* SCENARIO 3 */
        /* Débute comme le scénario 1, puis un employé se connecte, consulte le
        profil astral et l'historique du client puis indique qu'il est prêt.
        Lorsqu'il reçoit l'appel du client, il n'a pas d'inspiration et demande 
        donc de l'aide. Il termine ensuite la consultation, laisse un
        commentaire, consulte les activités de l'agence puis se déconnecte*/
        
        /*testerInscriptionClient();
        testerAuthentifierClient();
        testerListerTousCartomanciens();
        testerDemandeConsultation();
        testerSeDeconnecter();
        testerAuthentifierEmploye();
        testerObtenirProfilAstralDuClient();
        testerObtenirHistoriqueDuClient();
        testerDebuterConsultation();
        testerRealiserPrediction();
        testerTerminerConsultation();
        testerLaisserCommentaire();
        testerNbConsultationsParMedium();
        testerNbClientsParEmploye();
        testerTop5Medium();
        testerSeDeconnecter();*/
        
        
        
    }
    
    public static void debugHistorique() {
        Service service = new Service();
       
        long id = 8;
        Medium monMedium = service.trouverMediumParId(id);
        List <Consultation> histmed = monMedium.getHistorique();
        
        id = 5;
        Employe monEmploye = service.trouverEmployeParId(id);
        List <Consultation> histemp = monEmploye.getHistorique();
        
        id = 12;
        Client monClient = service.trouverClientParId(id);
        List <Consultation> histcli = monClient.getHistorique();
        
        System.out.println(" Medium : ");
        
        for (Consultation consultation : histmed) {
            System.out.println(consultation);
        }
        
        System.out.println(" Employe : ");
        
        for (Consultation consultation : histemp) {
            System.out.println(consultation);
        }
        
        System.out.println(" Client : ");
        
        for (Consultation consultation : histcli) {
            System.out.println(consultation);
        }
    }
    
    public static void testerInitialiserEmployes() {
        Service service = new Service();
        service.initialiserEmployes();
    }

    public static void testerInitialiserMediums() {
        Service service = new Service();
        service.initialiserMediums();
    }
    
    public static void testerTrouverEmployeParId() {
        Service service = new Service();
        long id = 3;
        System.out.println(service.trouverEmployeParId(id));
    }
    
    public static void testerListerTousEmployes() {
        Service service = new Service();
        List <Employe> tous = service.listerTousEmployes();

        for (Employe employe : tous) {
            System.out.println(employe);
        }
    }
    
    public static void testerListerTousMediums() {
        Service service = new Service();
        List <Medium> tous = service.listerTousMediums();

        for (Medium medium : tous) {
            System.out.println(medium);
        }
    }
    
    public static void testerInscriptionClient() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        
        Service service = new Service();
        
        Client monClient = new Client("Hugo", "Victor", dateFormat.parse("19/10/2003") , "20 avenue Albert Einstein", "0601234567", "vhugo@insa-lyon.fr");
        monClient.setMotDePasse("toto");
                
        Client monClient2 = new Client("Dupont", "Régis", dateFormat.parse("19/10/1963") , "20 avenue Albert Einstein", "687", "rdupont@insa-lyon.fr");
        monClient2.setMotDePasse("toto2");
        
        Client monClient3 = new Client("Frank", "Emile", dateFormat.parse("19/10/1945") , "20 avenue Albert Einstein", "689", "efranck@insa-lyon.fr");
        monClient3.setMotDePasse("toto3");
        
        service.inscriptionClient(monClient);
        service.inscriptionClient(monClient2);
        service.inscriptionClient(monClient3);
        
        service.donnerProfilAstral(monClient);
        service.donnerProfilAstral(monClient2);
        service.donnerProfilAstral(monClient3);
    }    
    
    public static void testerAuthentifierEmploye() {
        Service service = new Service();
        
        if (service.seConnecter("e.irisa@gmail.com", "toto") == true) {
            System.out.println("Réussite de la connexion employé");
            System.out.println("Trace : Bonjour " + service.obtenirEmployeConnecte().getPrenom());
        } else {
            System.out.println("Mail ou mot de passe incorrect");
        };
    }
      
    public static void testerAuthentifierClient() {
        Service service = new Service();
        
        if (service.seConnecter("vhugo@insa-lyon.fr", "toto") == true) {
            System.out.println("Réussite de la connexion client");
            System.out.println("Trace : Bonjour " + service.obtenirClientConnecte().getPrenom());
        } else {
            System.out.println("Mail ou mot de passe incorrect");
        };
        
    }
    
    public static void testerListerTousCartomanciens() {
        Service service = new Service();
        List <Medium> tous = service.listerCartomanciens();

        for (Medium medium : tous) {
            System.out.println(medium);
        }
    }
    
    public static void testerListerTousSpirites() {
        Service service = new Service();
        List <Medium> tous = service.listerSpirites();

        for (Medium medium : tous) {
            System.out.println(medium);
        }
    }
    
    public static void testerListerTousAstrologues() {
        Service service = new Service();
        List <Medium> tous = service.listerAstrologues();

        for (Medium medium : tous) {
            System.out.println(medium);
        }
    }

    public static void testerDemandeConsultation()throws ParseException {

        Service service = new Service();
        
        long id = 8;
        Medium monMedium = service.trouverMediumParId(id);
        
        service.demanderConsultation(monMedium);
        
    }
    
    public static void testerObtenirProfilAstralPourClient() throws IOException {

        Service service = new Service();
        System.out.println(service.obtenirProfilAstralPourClient());
    }
    
    public static void testerHistoriqueClient() {

        Service service = new Service();
        
        List<Consultation> ConsultationClient = service.obtenirHistoriquePourClient();
        for (Consultation consultation : ConsultationClient) {
            System.out.println(consultation);
        }
        
    }
    
    public static void testerObtenirProfilAstralDuClient() throws IOException {

        Service service = new Service();
        System.out.println(service.obtenirProfilAstralDuClient());
    }
    
    public static void testerObtenirHistoriqueDuClient() throws IOException {

        Service service = new Service();
        System.out.println(service.obtenirHistoriqueDuClient());
    }
    
    public static void testerDebuterConsultation() {
        Service service = new Service();
        service.debuterConsultation();
    }
    
    public static void testerTerminerConsultation() {
        Service service = new Service();
        service.terminerConsultation();
    }
    
    public static void testerRealiserPrediction() throws IOException {
        Service service = new Service();  
        service.realiserPrediction(4,3,2);
    }
    
    public static void testerLaisserCommentaire() {
        Service service = new Service();
        service.ajouterCommentaire("Ceci est un commentaire");
    }
    
    
    
    public static void testerNbConsultationsParMedium() {
        Service service = new Service();
        service.chercherNombreConsultationsParMedium();
          
    }
    
    public static void testerNbClientsParEmploye() {
    
        Service service = new Service();
        service.chercherNombreClientsParEmploye();
          
    }
    
    public static void testerTop5Medium() {
        Service service = new Service();
        service.chercherTop5Medium();
    }

    public static void testerSeDeconnecter() {
        Service service = new Service();
        service.seDeconnecter();
    }
    
}

package metier.service;

import dao.JpaUtil;
import metier.modele.Employe;
import metier.modele.Client;
import metier.modele.Medium;
import metier.modele.Cartomancien;
import metier.modele.Spirite;
import metier.modele.Astrologue;
import metier.modele.Consultation;
import dao.ClientDAO;
import dao.EmployeDAO;
import dao.MediumDAO;
import dao.ConsultationDAO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import metier.modele.ProfilAstral;
import util.Message;
import util.AstroNetApi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mnguyen
 */
public class Service {
    
    public Service() {}
    
    static long idClientConnecte = 0;
    
    static long idEmployeConnecte = 0;
    
    
    public void initialiserEmployes() {
        
        Employe monEmploye1 = new Employe("Poisson", "Camille", "0600000001", "c.poisson@gmail.com", "F");
        monEmploye1.setMotDePasse("toto");
                
        Employe monEmploye2 = new Employe("Dupond", "Hervé", "0600000002", "h.dupond@gmail.com", "H");
        monEmploye2.setMotDePasse("toto");

        Employe monEmploye3 = new Employe("Morel", "Louise", "0600000003", "l.morel@gmail.com", "F");
        monEmploye3.setMotDePasse("toto");

        Employe monEmploye4 = new Employe("Fapo", "Louis", "0600000004", "l.fapo@gmail.com", "H");
        monEmploye4.setMotDePasse("toto");
        
        Employe monEmploye5 = new Employe("Irisa", "Eva", "0600000005", "e.irisa@gmail.com", "F");
        monEmploye5.setMotDePasse("toto");
        
        EmployeDAO empdao = new EmployeDAO();
        
        try {
            JpaUtil.creerContextePersistance();
            JpaUtil.ouvrirTransaction();
            empdao.creer(monEmploye1);
            empdao.creer(monEmploye2);
            empdao.creer(monEmploye3);
            empdao.creer(monEmploye4);
            empdao.creer(monEmploye5);
            JpaUtil.validerTransaction();
            
            System.out.println("Trace : Succès initialiserEmployes");
        } catch (Exception ex) {
            JpaUtil.annulerTransaction();
            ex.printStackTrace();
            System.out.println("Trace : Echec initialiserEmployes");
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        
    }
    
    public void initialiserMediums() {

        Medium monMedium1 = new Spirite("Gwennaelle", "F", "Spécialiste des grandes conversations au-delà de toutes les frontières", "Boule de cristal");
        Medium monMedium2 = new Spirite("Professeur Tran", "H", "Votre avenir est devant vous : regardons-le ensemble !", "Marc de café, boule de cristal, oreilles de lapin");

        Medium monMedium3 = new Cartomancien("Mme Irma", "F", "Comprenez votre entourage grâce à mes cartes ! Résultats rapides.");
        Medium monMedium4 = new Cartomancien("Endora", "F", "Mes cartes répondront à toutes vos questions personnelles");

        Medium monMedium5 = new Astrologue("Serena", "F", "Basée à Champigny-sur-Marnes, Serena vous révèlera votre avenir pour éclairer votre passé", "ENS-Astro", "2006");
        Medium monMedium6 = new Astrologue("Mr M", "H", "Avenir, avenir, que nous réserves-tu ? N'attendez plus, demandez à me consulter !", "Institut des Nouveaux Savoirs Astrologiques", "2010");
        
        MediumDAO meddao = new MediumDAO();
                
        try {
            JpaUtil.creerContextePersistance();
            JpaUtil.ouvrirTransaction();
            meddao.creer(monMedium1);
            meddao.creer(monMedium2);
            meddao.creer(monMedium3);
            meddao.creer(monMedium4);
            meddao.creer(monMedium5);
            meddao.creer(monMedium6);
            JpaUtil.validerTransaction();
            System.out.println("Trace : Succès creerMedium ");
            
        } catch (Exception ex) {
            JpaUtil.annulerTransaction();
            ex.printStackTrace();
            System.out.println("Trace : Echec creerMedium ");
        } finally {
            JpaUtil.fermerContextePersistance();
        }
    }
    
    public Employe trouverEmployeParId(Long id) {        
        
       EmployeDAO empdao = new EmployeDAO();
       
       JpaUtil.creerContextePersistance();
       Employe monEmploye = empdao.chercherParId(id);
            
       if (monEmploye != null) {
           System.out.println("Trace : Succès trouverEmployeParId");
       } else {
           System.out.println("Trace : Echec trouverEmployeParId");
       }
     
       JpaUtil.fermerContextePersistance();
       
      return monEmploye;
    }


    public List<Employe> listerTousEmployes() {

       EmployeDAO empdao = new EmployeDAO();

       JpaUtil.creerContextePersistance();
       
       List<Employe> maListe = empdao.chercherTous();

       System.out.println("Trace : Succès listerTousEmployes");
       JpaUtil.fermerContextePersistance();

       return maListe;
    }


    public Medium trouverMediumParId(Long id) {        
        
       MediumDAO meddao = new MediumDAO();
       
       
       JpaUtil.creerContextePersistance();
       Medium monMedium = meddao.chercherParId(id);
       
       if (monMedium != null) {
           System.out.println("Trace : Succès trouverMediumParId");
       } else {
           System.out.println("Trace : Echec trouverMediumParId");
       }
           
       JpaUtil.fermerContextePersistance();
       
       
       
      return monMedium;
    }
    
    public List<Medium> listerTousMediums() {
        
       MediumDAO meddao = new MediumDAO();
       
       JpaUtil.creerContextePersistance();
       
       List<Medium> maListe = meddao.chercherTous();
            
       System.out.println("Trace : Succès listerTousMediums");
       JpaUtil.fermerContextePersistance();

       return maListe;
    }
    
    public List<Medium> listerCartomanciens() {
        
       MediumDAO meddao = new MediumDAO();
       
       JpaUtil.creerContextePersistance();
       
       List<Medium> maListe = meddao.chercherCartomanciens();
            
       System.out.println("Trace : Succès listerCartomanciens");
       JpaUtil.fermerContextePersistance();

       return maListe;
    }
    
    public List<Medium> listerSpirites() {
        
       MediumDAO meddao = new MediumDAO();
       
       JpaUtil.creerContextePersistance();
       
       List<Medium> maListe = meddao.chercherSpirites();
            
       System.out.println("Trace : Succès listerSpirites");
       JpaUtil.fermerContextePersistance();

       return maListe;
    }
    
    public List<Medium> listerAstrologues() {
        
       MediumDAO meddao = new MediumDAO();
       
       JpaUtil.creerContextePersistance();
       
       List<Medium> maListe = meddao.chercherAstrologues();
            
       System.out.println("Trace : Succès listerAstrologues");
       JpaUtil.fermerContextePersistance();

       return maListe;
    }
    
    public Client trouverClientParId(Long id) {        
        
       ClientDAO clidao = new ClientDAO();
       
       
       JpaUtil.creerContextePersistance();
       Client monClient = clidao.chercherParId(id);
            
       if (monClient != null) {
           System.out.println("Trace : Succès trouverClientParId");
       } else {
           System.out.println("Trace : Echec trouverClientParId");
       }
     
       JpaUtil.fermerContextePersistance();
       
      return monClient;
    }
    
    public void inscriptionClient(Client monClient) {
        
        if (idEmployeConnecte == 0 && idClientConnecte == 0) {
   
            ClientDAO clidao = new ClientDAO();

            String corpsMail;

            try {
                JpaUtil.creerContextePersistance();
                JpaUtil.ouvrirTransaction();
                clidao.creer(monClient);

                JpaUtil.validerTransaction();

                corpsMail = "Bonjour " + monClient.getPrenom() + ", nous vous confirmons votre inscription au service PREDICT'IF. Rendez-vous vite sur notre site pour consulter votre profil astrologique et profiter des dons incroyables de nos mediums.";
                Message.envoyerMail("contact@predict.if", monClient.getMail(), "Bienvenue chez PREDICT'IF", corpsMail);

                System.out.println("Trace : Succès inscriptionClient");
            }
            catch(Exception ex) {

                corpsMail = "Bonjour " + monClient.getPrenom() + ", votre inscription au service PREDICT'IF a malencontreusement échoué... Merci de recommencer ultérieurement.";

                Message.envoyerMail("contact@predict.if", monClient.getMail(), "Erreur de l'inscription chez PREDICT'IF", corpsMail);
                JpaUtil.annulerTransaction();
                ex.printStackTrace();

                System.out.println("Trace : Echec inscriptionClient ");
            }finally {
                JpaUtil.fermerContextePersistance();
            }
        } else System.out.println("Trace : Echec inscriptionClient : un utilisateur est déjà connecté");
    }
    
    public ProfilAstral donnerProfilAstral(Client monClient) {
            
        ProfilAstral unProfilAstral = null;
        
        ClientDAO clidao = new ClientDAO();
        AstroNetApi astroApi = new AstroNetApi();

        try {
            JpaUtil.creerContextePersistance();
            JpaUtil.ouvrirTransaction();
            
            Client unClient = clidao.chercherParId(monClient.getId());
            
            List<String> profil = astroApi.getProfil(unClient.getPrenom(), unClient.getDateNaissance());
            String signeZodiaque = profil.get(0);
            String signeChinois = profil.get(1);
            String couleur = profil.get(2);
            String animal = profil.get(3);
            
            unProfilAstral = new ProfilAstral(signeZodiaque, signeChinois, couleur, animal);
            unClient.setMonProfilAstral(unProfilAstral);
            
            JpaUtil.validerTransaction();
            System.out.println("Trace : Succès donnerProfilAstral ");
            
        }
        catch(Exception ex) {
            JpaUtil.annulerTransaction();
            ex.printStackTrace();
            System.out.println("Trace : Echec donnerProfilAstral ");
        }finally {
            JpaUtil.fermerContextePersistance();
        }
        
        return unProfilAstral;
        
    }
    
    public void donnerProfilAstral() {
        Client monClient = trouverClientParId(idClientConnecte);
        
        ClientDAO clidao = new ClientDAO();
        AstroNetApi astroApi = new AstroNetApi();

        try {
            JpaUtil.creerContextePersistance();
            JpaUtil.ouvrirTransaction();
            
            Client unClient = clidao.chercherParId(monClient.getId());
            
            List<String> profil = astroApi.getProfil(unClient.getPrenom(), unClient.getDateNaissance());
            String signeZodiaque = profil.get(0);
            String signeChinois = profil.get(1);
            String couleur = profil.get(2);
            String animal = profil.get(3);
            
            ProfilAstral unProfilAstral = new ProfilAstral(signeZodiaque, signeChinois, couleur, animal);
            unClient.setMonProfilAstral(unProfilAstral);
            
            JpaUtil.validerTransaction();
            System.out.println("Trace : Succès donnerProfilAstral ");
            
        }
        catch(Exception ex) {
            JpaUtil.annulerTransaction();
            ex.printStackTrace();
            System.out.println("Trace : Echec donnerProfilAstral ");
        }finally {
            JpaUtil.fermerContextePersistance();
        }
        
    }
    
    public Employe authentifierEmploye(String mail, String motDePasse) {  
       
        Employe monEmploye = null;

        if (idEmployeConnecte == 0 && idClientConnecte == 0) {

            EmployeDAO empdao = new EmployeDAO();

            JpaUtil.creerContextePersistance();

            List<Employe> maListe = empdao.chercherParMail(mail, motDePasse);

            if (!maListe.isEmpty()) {
               monEmploye = maListe.get(0);

               idEmployeConnecte = monEmploye.getId();

               System.out.println("Trace : Succès authentifierEmploye");
            }

            if (monEmploye == null) {
              System.out.println("Trace : Echec authentifierEmploye");
            }

            JpaUtil.fermerContextePersistance();
        } else System.out.println("Trace : Echec authentifierEmploye : un utilisateur est déjà connecté");
      
      return monEmploye;
    }
    
    
    public Client authentifierClient(String mail, String motDePasse) {   
       
        Client monClient = null;

        if (idEmployeConnecte == 0 && idClientConnecte == 0) {
        
            ClientDAO clidao = new ClientDAO();

            JpaUtil.creerContextePersistance();

            List<Client> maListe = clidao.chercherParMail(mail, motDePasse);

            if (!maListe.isEmpty()) {
               monClient = maListe.get(0);

               idClientConnecte = monClient.getId();

               System.out.println("Trace : Succès authentifierClient");
               JpaUtil.fermerContextePersistance();
            }

            if (monClient == null) System.out.println("Trace : Echec authentifierClient");
            
        } else System.out.println("Trace : Echec authentifierClient : un utilisateur est déjà connecté");

        return monClient;
    }
    
    public boolean seConnecter(String mail, String motDePasse) {

        boolean estConnecte = false;
        
        if (authentifierEmploye(mail, motDePasse) != null) {
            estConnecte = true;
            System.out.println("Trace : Succès seConnecter");
        } else if (authentifierClient(mail, motDePasse) != null){
            estConnecte = true;
            System.out.println("Trace : Succès seConnecter");
        } else {
            System.out.println("Trace : Echec seConnecter");
        }
        
        return estConnecte;
    }
    
    public Client obtenirClientConnecte() {
        Client clientConnecte = null;
        if (idClientConnecte != 0){
            clientConnecte = trouverClientParId(idClientConnecte);
            System.out.println("Trace : Succès obtenirClientConnecte");
        } else System.out.println("Echec : Succès obtenirClientConnecte");
        
        return clientConnecte;
    }
    
    public Employe obtenirEmployeConnecte() {
        Employe employeConnecte = null;
        if (idEmployeConnecte != 0){
            employeConnecte = trouverEmployeParId(idEmployeConnecte);
            System.out.println("Trace : Succès obtenirEmployeConnecte");
        } else System.out.println("Echec : Succès obtenirEmployeConnecte");
        
        return employeConnecte;
    }
    
    public void seDeconnecter() {
        if (idEmployeConnecte != 0) {
            idEmployeConnecte = 0;
            System.out.println("Déconnexion de l'employé réussie");
        } else if (idClientConnecte != 0) {
            idClientConnecte = 0;
            System.out.println("Déconnexion du client réussie");
        } else System.out.println("Pas d'utilisateur connecté");
    }
    
    
    public boolean demanderConsultation(Client monClient, Medium monMedium) {

        boolean reussite = true;
        
        if (idClientConnecte != 0) {
        
            EmployeDAO empdao = new EmployeDAO();
            ClientDAO clidao = new ClientDAO();
            MediumDAO meddao = new MediumDAO();

            JpaUtil.creerContextePersistance();
            Employe unEmploye = empdao.chercherPourConsultation(monMedium);

            Medium unMedium = meddao.chercherParId(monMedium.getId());
            Client unClient = clidao.chercherParId(monClient.getId());

            if (unEmploye == null) {
                System.out.println("Trace : Echec de la demande de consultation");
                reussite = false;
            } else {
                ConsultationDAO condao = new ConsultationDAO();

                try {
                    JpaUtil.ouvrirTransaction();

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
                    Date date = Calendar.getInstance().getTime();
                    String dateString = dateFormat.format(date);

                    LocalTime heureDebut = LocalTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                    String heureString = heureDebut.format(formatter);

                    Consultation uneConsultation = new Consultation(unEmploye, unMedium, unClient, dateFormat.parse(dateString), heureString);
                    condao.creer(uneConsultation);

                    unEmploye.ajouterConsultation(uneConsultation);
                    unClient.ajouterConsultation(uneConsultation);
                    unMedium.ajouterConsultation(uneConsultation);

                    unEmploye.setDisponible(false);

                    JpaUtil.validerTransaction();


                    System.out.println("Pour " + unEmploye.getPrenom() + " " + unEmploye.getNom() + ", Tel :" + unEmploye.getTelephonePro());
                    System.out.println("Message : Bonjour " + unEmploye.getPrenom() + ". Consultation requise pour " + unClient.getPrenom() + " " + unClient.getNom() + ". Medium à incarner : " + unMedium.getDenomination() +".");

                    System.out.println("Trace : Succès demanderConsultation");

                }
                catch(Exception ex) {
                    JpaUtil.annulerTransaction();
                    ex.printStackTrace();
                    System.out.println("Trace : Echec demanderConsultation");
                }

            }

            JpaUtil.fermerContextePersistance();
        } else System.out.println("Trace : Echec demanderConsultation ; le client n'est pas connecté");
        
        return reussite;
        
    }
    
    
    public boolean demanderConsultation(Medium monMedium) {

        boolean reussite = true;
        
        if (idClientConnecte != 0) {
        
            Client monClient = trouverClientParId(idClientConnecte);

            EmployeDAO empdao = new EmployeDAO();
            ClientDAO clidao = new ClientDAO();
            MediumDAO meddao = new MediumDAO();

            JpaUtil.creerContextePersistance();
            Employe unEmploye = empdao.chercherPourConsultation(monMedium);

            Medium unMedium = meddao.chercherParId(monMedium.getId());
            Client unClient = clidao.chercherParId(monClient.getId());

            if (unEmploye == null) {
                System.out.println("Trace : Echec de la demande de consultation");
                reussite = false;
            } else {
                ConsultationDAO condao = new ConsultationDAO();

                try {
                    JpaUtil.ouvrirTransaction();

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
                    Date date = Calendar.getInstance().getTime();
                    String dateString = dateFormat.format(date);

                    LocalTime heureDebut = LocalTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                    String heureString = heureDebut.format(formatter);

                    Consultation uneConsultation = new Consultation(unEmploye, unMedium, unClient, dateFormat.parse(dateString), heureString);
                    condao.creer(uneConsultation);

                    unEmploye.ajouterConsultation(uneConsultation);
                    unClient.ajouterConsultation(uneConsultation);
                    unMedium.ajouterConsultation(uneConsultation);

                    unEmploye.setDisponible(false);

                    JpaUtil.validerTransaction();


                    System.out.println("Pour " + unEmploye.getPrenom() + " " + unEmploye.getNom() + ", Tel :" + unEmploye.getTelephonePro());
                    System.out.println("Message : Bonjour " + unEmploye.getPrenom() + ". Consultation requise pour " + unClient.getPrenom() + " " + unClient.getNom() + ". Medium à incarner : " + unMedium.getDenomination() +".");

                    System.out.println("Trace : Succès demanderConsultation");

                }
                catch(Exception ex) {
                    JpaUtil.annulerTransaction();
                    ex.printStackTrace();
                    System.out.println("Trace : Echec demanderConsultation");
                }

            }

            JpaUtil.fermerContextePersistance();
        } else System.out.println("Trace : Echec demanderConsultation ; le client n'est pas connecté");
        
        return reussite;
        
    }
    
    public ProfilAstral obtenirProfilAstralPourClient() {  
       
        ProfilAstral unProfilAstral = null;

        if (idClientConnecte != 0) {

            ClientDAO clidao = new ClientDAO();

            JpaUtil.creerContextePersistance();

            Client unClient = clidao.chercherParId(idClientConnecte);

            if (unClient != null) {
                unProfilAstral = unClient.getMonProfilAstral(); 
                if (unProfilAstral != null) {
                    System.out.println("Trace : Succès obtenirProfilAstralPourClient");
                } else {
                    System.out.println("Trace : Echec obtenirProfilAstralPourClient");
                }
            } else {
                System.out.println("Trace : Echec obtenirProfilAstralPourClient");
            }


            JpaUtil.fermerContextePersistance();
            
        } else System.out.println("Trace : Echec obtenirProfilAstralPourClient : le client n'est pas connecté");
       
      return unProfilAstral;
    }
    
    public List<Consultation> obtenirHistoriquePourClient() { 
       
        List<Consultation> mesConsultations = null;

        if (idClientConnecte != 0) {

            ClientDAO clidao = new ClientDAO();

            JpaUtil.creerContextePersistance();

            Client unClient = clidao.chercherParId(idClientConnecte);

            if (unClient != null) {
                mesConsultations = unClient.getHistorique(); 
                if (mesConsultations != null) {
                    System.out.println("Trace : Succès obtenirHistoriquePourClient");
                } else {
                    System.out.println("Trace : Echec obtenirHistoriquePourClient");
                }
            } else {
                System.out.println("Trace : Echec obtenirHistoriquePourClient");
            }


            JpaUtil.fermerContextePersistance();
        
        } else System.out.println("Trace : Echec obtenirHistoriquePourClient : le client n'est pas connecté");
       
        return mesConsultations;
    }
    
    public Consultation trouverConsultationParId(Long id) {        
        
        ConsultationDAO condao = new ConsultationDAO();

        JpaUtil.creerContextePersistance();
        Consultation maConsultation = condao.chercherParId(id);

        System.out.println("Trace : Succès trouverConsultationParId");

        JpaUtil.fermerContextePersistance();

        return maConsultation;
    }
    
    public ProfilAstral obtenirProfilAstralDuClient() { 
       
        ProfilAstral unProfilAstral = null;

        if (idEmployeConnecte != 0) {

            ClientDAO clidao = new ClientDAO();
            EmployeDAO empdao = new EmployeDAO();

            JpaUtil.creerContextePersistance();
            Employe unEmploye = empdao.chercherParId(idEmployeConnecte);

            if (unEmploye != null) {
                Client monClient = clidao.chercherParEmploye(unEmploye); //marche pas l'idée était de d'avoir le client de la table consultation ou idEmploye=idEmployeConnecte et etat=demandée
                if (monClient != null) {
                    unProfilAstral = monClient.getMonProfilAstral(); 
                    if (unProfilAstral != null) {
                    System.out.println("Trace : Succès obtenirProfilAstralDuClient");
                    } else {
                    System.out.println("Trace : Echec obtenirProfilAstralDuClient - Pas de profil astral");
                    }
                } else System.out.println("Trace : Echec obtenirProfilAstralDuClient - Pas de client");
            } else System.out.println("Trace : Echec obtenirProfilAstralDuClient - Pas d'employé");
            
            JpaUtil.fermerContextePersistance();
            
        } else System.out.println("Trace : Echec obtenirProfilAstralDuClient : l'employé n'est pas connecté");
       
        return unProfilAstral;
    }
    
    public List<Consultation> obtenirHistoriqueDuClient() {   
        
        List<Consultation> mesConsultations = null;
        
        if (idEmployeConnecte != 0) {

            ClientDAO clidao = new ClientDAO();
            EmployeDAO empdao = new EmployeDAO();

            JpaUtil.creerContextePersistance();

            Employe unEmploye = empdao.chercherParId(idEmployeConnecte);
            
            if (unEmploye != null) {
                Client unClient = clidao.chercherParEmploye(unEmploye); //marche pas l'idée était de d'avoir le client de la table consultation ou idEmploye=idEmployeConnecte et etat=demandée
                if (unClient != null) {
                    mesConsultations = unClient.getHistorique();
                    if (!mesConsultations.isEmpty()) {
                        System.out.println("Trace : Succès obtenirHistoriqueDuClient");
                    } else System.out.println("Trace : Succès obtenirHistoriqueDuClient - historique vide");
                } else System.out.println("Trace : Echec obtenirHistoriqueDuClient - pas de client");
            } else System.out.println("Trace : Echec obtenirHistoriqueDuClient - pas d'employé");
            JpaUtil.fermerContextePersistance();
            
        } else System.out.println("Trace : Echec obtenirHistoriqueDuClient : l'employé n'est pas connecté");
       
        return mesConsultations;
    }
    
    public void realiserPrediction(int niveauAmour, int niveauSante, int niveauTravail) throws IOException {
        
        if (idEmployeConnecte != 0) {
        
            AstroNetApi astroApi = new AstroNetApi();

            ClientDAO clidao = new ClientDAO();

            EmployeDAO empdao = new EmployeDAO();

            JpaUtil.creerContextePersistance();

            ProfilAstral unProfilAstral;

            Employe unEmploye = empdao.chercherParId(idEmployeConnecte);

            if (unEmploye != null) {
                Client unClient = clidao.chercherParEmploye(unEmploye); //marche pas l'idée était de d'avoir le client de la table consultation ou idEmploye=idEmployeConnecte et etat=demandée
                if (unClient != null) {
                    unProfilAstral = unClient.getMonProfilAstral();
                    if (unProfilAstral != null) {
                        List<String> predictions = astroApi.getPredictions(unProfilAstral.getCouleurPorteBonheur(), unProfilAstral.getAnimalTotem(), niveauAmour, niveauSante, niveauTravail);
                        String predictionAmour = predictions.get(0);
                        String predictionSante = predictions.get(1);
                        String predictionTravail = predictions.get(2);

                        System.out.println("~<[ Prédictions ]>~");
                        System.out.println("[ Amour ] " + predictionAmour);
                        System.out.println("[ Santé ] " + predictionSante);
                        System.out.println("[Travail] " + predictionTravail);
                        System.out.println("Trace : Succès realiserPrediction");
                    } else System.out.println("Trace : Echec realiserPrediction - pas de profil astral");
                } else System.out.println("Trace : Echec realiserPrediction - pas de client"); 
            } else System.out.println("Trace : Echec realiserPrediction - pas d'employé");

            JpaUtil.fermerContextePersistance();
            
        } else System.out.println("Trace : Echec realiserPrediction : l'employé n'est pas connecté");
        
    }
    
    public void debuterConsultation() {      
        
        if (idEmployeConnecte != 0) {
        
            ConsultationDAO condao = new ConsultationDAO();
            EmployeDAO empdao = new EmployeDAO();

            JpaUtil.creerContextePersistance();
            
            Employe unEmploye = empdao.chercherParId(idEmployeConnecte);

            Consultation uneConsultation = condao.chercherParEmploye(unEmploye);
            Client unClient = uneConsultation.getClient();
            Medium unMedium = uneConsultation.getMedium();

            System.out.println("Pour " + unEmploye.getPrenom() + " " + unEmploye.getNom() + ", Tel :" + unEmploye.getTelephonePro());
            System.out.println("Message : Bonjour " + unEmploye.getPrenom() + ". Consultation requise pour " + unClient.getPrenom() + " " + unClient.getNom() + ". Medium à incarner : " + unMedium.getDenomination() +".");

            uneConsultation.setEtat("Prête");

            System.out.println("Trace : Succès debuterConsultation");

            JpaUtil.fermerContextePersistance();
        
        } else System.out.println("Trace : Echec debuterConsultation : l'employé n'est pas connecté");
    }
    
     public void terminerConsultation() {      
        
        if (idEmployeConnecte != 0) {     
        
            ConsultationDAO condao = new ConsultationDAO();
            EmployeDAO empdao = new EmployeDAO();

            JpaUtil.creerContextePersistance();

            Employe unEmploye = empdao.chercherParId(idEmployeConnecte);

            Consultation uneConsultation = condao.chercherParEmploye(unEmploye);
            
            uneConsultation.setEtat("Terminée");
            unEmploye.setDisponible(true);

            System.out.println("Trace : Succès terminerConsultation");

            JpaUtil.fermerContextePersistance();
            
        } else System.out.println("Trace : Echec terminerConsultation : l'employé n'est pas connecté");
    }
    
    
    public void ajouterCommentaire(String commentaire) {     
        
        if (idEmployeConnecte != 0) {           
        
            ConsultationDAO condao = new ConsultationDAO();

            EmployeDAO empdao = new EmployeDAO();

            Employe unEmploye = empdao.chercherParId(idEmployeConnecte);

            JpaUtil.creerContextePersistance();
            Consultation uneConsultation = condao.chercherParEmployeTerminee(unEmploye);
            if (uneConsultation != null) {
                uneConsultation.setCommentaire(commentaire);
                System.out.println("Trace : Succès ajouterCommentaire");
            } else System.out.println("Trace : Echec ajouterCommentaire");


            JpaUtil.fermerContextePersistance();
            
        } else System.out.println("Trace : Succès ajouterCommentaire : l'employé n'est pas connecté");
    }
    
    
    public long chercherNombreConsultationsParMedium(Medium monMedium) {
        
       ConsultationDAO condao = new ConsultationDAO();
       
       MediumDAO meddao = new MediumDAO();
       
       JpaUtil.creerContextePersistance();
       
       Medium unMedium = meddao.chercherParId(monMedium.getId());
       
       long resultat=condao.chercherNbConsultationsParMedium(unMedium);
            
       System.out.println("Trace : Succès getNombreConsultationParMedium");
     
       JpaUtil.fermerContextePersistance();
       
       return resultat;
       
    }
    
    public long chercherNombreClientsParEmploye(Employe monEmploye) {
        
        long resultat = 0;
        
        if (idEmployeConnecte != 0) {   // Autorisé uniquement si c'est un employé qui est connecté -> accès aux stats seulement pour les employés
        
            ConsultationDAO condao = new ConsultationDAO();

            EmployeDAO empdao = new EmployeDAO();

            JpaUtil.creerContextePersistance();

            Employe unEmploye = empdao.chercherParId(monEmploye.getId());

            resultat=condao.chercherNbClientsParEmploye(unEmploye);

            System.out.println("Trace : Succès getNombreConsultationParMedium");

            JpaUtil.fermerContextePersistance();
            
        } else System.out.println("Trace : Echec getNombreConsultationParMedium : pas d'employé connecté");

        return resultat;
       
    }
    
    public List<Medium> chercherTop5Medium() {
        
       ConsultationDAO condao = new ConsultationDAO();
      
       JpaUtil.creerContextePersistance();
       
       
       List<Medium> resultat=condao.chercherTopMedium();
            
       System.out.println("Trace : Succès getNombreConsultationParMedium");
     
       JpaUtil.fermerContextePersistance();
       
       return resultat;
       
    }
    
    
}

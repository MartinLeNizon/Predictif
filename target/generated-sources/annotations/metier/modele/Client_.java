package metier.modele;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import metier.modele.Consultation;
import metier.modele.ProfilAstral;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-04-30T23:47:13")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> motDePasse;
    public static volatile SingularAttribute<Client, String> mail;
    public static volatile SingularAttribute<Client, Date> dateNaissance;
    public static volatile SingularAttribute<Client, Long> id;
    public static volatile SingularAttribute<Client, String> adressePostale;
    public static volatile SingularAttribute<Client, String> nom;
    public static volatile SingularAttribute<Client, String> prenom;
    public static volatile SingularAttribute<Client, String> noTelephone;
    public static volatile SingularAttribute<Client, ProfilAstral> monProfilAstral;
    public static volatile ListAttribute<Client, Consultation> historique;

}
package ma.ac.emi.ginfo.elkihelayman;

import ma.ac.emi.ginfo.elkihelayman.entities.*;
import ma.ac.emi.ginfo.elkihelayman.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ElkihelaymanApplication implements CommandLineRunner {
    private final UsineRepository usineRepository;
    private final EmployeRepository employeRepository;
    private final ResponsableRepository responsableRepository;
    private final OperateurRepository operateurRepository;
    private final ModeleRepository modeleRepository;
    private final MoteurRepository moteurRepository;
    private final DefautRepository defautRepository;
    private final TypeRepository typeRepository;

    public ElkihelaymanApplication(UsineRepository usineRepository,
                                   EmployeRepository employeRepository,
                                   ResponsableRepository responsableRepository,
                                   OperateurRepository operateurRepository,
                                   ModeleRepository modeleRepository,
                                   MoteurRepository moteurRepository,
                                   DefautRepository defautRepository,
                                   TypeRepository typeRepository) {
        this.usineRepository = usineRepository;
        this.employeRepository = employeRepository;
        this.responsableRepository = responsableRepository;
        this.operateurRepository = operateurRepository;
        this.modeleRepository = modeleRepository;
        this.moteurRepository = moteurRepository;
        this.defautRepository = defautRepository;
        this.typeRepository = typeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ElkihelaymanApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Usine usine = new Usine("usine1","maroc","rabat");
        Employe employe = new Employe("Elkihel", "Ayman", "choffeur");
        Responsable responsable = new Responsable("amine", "amine", "respo");
        Operateur operateur = new Operateur("yass", "yass", "oper");
        Modele modele = new Modele("code", 5,1, LocalDate.now(), LocalDate.now());
        Moteur moteur = new Moteur(5,8,LocalDate.now());
        Defaut defaut = new Defaut(LocalDate.now(),"desc", 5,8);
        Type type = new Type(9, "type");

        usine.getEmployes().add(employe);
        usine.getEmployes().add(responsable);
        usine.getEmployes().add(operateur);

        employe.setUsine(usine);
        operateur.setUsine(usine);
        responsable.setUsine(usine);

        usine.getModeles().add(modele);
        modele.setUsine(usine);

        modele.getMoteurs().add(moteur);
        moteur.setModele(modele);

        moteur.getDefauts().add(defaut);
        defaut.setMoteur(moteur);

        type.getDefauts().add(defaut);
        defaut.setType(type);

        defaut.setOperateur(operateur);
        operateur.getDefauts().add(defaut);

        modele.setResponsable(responsable);
        responsable.getModeles().add(modele);

        usineRepository.save(usine);
        employeRepository.save(employe);
        responsableRepository.save(responsable);
        operateurRepository.save(operateur);
        modeleRepository.save(modele);
        moteurRepository.save(moteur);
        defautRepository.save(defaut);
        typeRepository.save(type);

        System.out.println(usine);
        System.out.println(employe);
        System.out.println(moteur);
        System.out.println(modele);
        System.out.println(type);
        System.out.println(defaut);
    }
}

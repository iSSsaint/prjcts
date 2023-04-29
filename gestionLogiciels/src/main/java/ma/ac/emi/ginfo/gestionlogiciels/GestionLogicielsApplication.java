package ma.ac.emi.ginfo.gestionlogiciels;

import ma.ac.emi.ginfo.gestionlogiciels.entities.*;
import ma.ac.emi.ginfo.gestionlogiciels.entities.embedded.ComposantId;
import ma.ac.emi.ginfo.gestionlogiciels.entities.embedded.LicenseId;
import ma.ac.emi.ginfo.gestionlogiciels.entities.embedded.LogicielId;
import ma.ac.emi.ginfo.gestionlogiciels.repositories.*;
import ma.ac.emi.ginfo.gestionlogiciels.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class GestionLogicielsApplication {
    @Autowired
    LogicielRepository lr;

    @Autowired
    VersionRepository vr;

    @Autowired
    CategoryRepository cr;

    @Autowired
    ApplicationRepository ar;

    @Autowired
    LibrairieRepository libr;

    @Autowired
    ComposantRepository cpr;

    @Autowired
    LicenseRepository lisr;

    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(GestionLogicielsApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(){
        return args -> {
            //Logiciel and Version classes test
            LogicielVersion version1 = new LogicielVersion(1,0);
            LogicielVersion version2 = new LogicielVersion(2,3);

            vr.saveAll(List.of(version1, version2));

            Logiciel logiciel1 = new Logiciel(new LogicielId("Vs Code",version1),"Description of vs code",new URL("https://vscode.dev/"));
            Logiciel logiciel2 = new Logiciel(new LogicielId("Intellij",version2),"Description of Intellij",new URL("https://www.jetbrains.com/idea"));
            Logiciel logiciel3 = new Logiciel(new LogicielId("Fortnite",version2),"Description of Fortnite",new URL("https://www.fortnite.com/"));

            this.lr.saveAll(List.of(logiciel1,logiciel2,logiciel3));

            System.out.println(this.lr.findAll());
            //Logiciel And Categories Test
            Category ide = new Category("IDEs");
            Category games = new Category("Games");
            Category applications = new Category("Applications");

            cr.saveAll(List.of(ide, games, applications));

            logiciel1.setPrincipalCategory(ide);
            logiciel1.setCategories(Arrays.asList(applications));

            logiciel2.setPrincipalCategory(ide);
            logiciel2.setCategories(Arrays.asList(applications));

            logiciel3.setPrincipalCategory(games);
            logiciel3.setCategories(Arrays.asList(applications));

            System.out.println(this.cr.findAll());
            System.out.println(this.lr.findAll());

            //Test Application Sub Class
            Application app1 = new Application(new LogicielId("Application1",version1),"Test app1 Description",new URL("https://app.codehaus.org"));
            Application app2 = new Application(new LogicielId("Application2",version1),"Test app2 Description",new URL("https://app.codehaus.org"));

            app1.getLogiciels().addAll(List.of(logiciel1,logiciel2));
            app2.getLogiciels().addAll(List.of(logiciel1,logiciel3));
            System.out.println(app1);
            ar.saveAll(List.of(app1,app2));
            logiciel1.getApplications().addAll(List.of(app1,app2));

            System.out.println(ar.findAll());
            System.out.println(logiciel1.getApplications());

            //Test Librairie Sub Class
            Librairie lib1 = new Librairie(new LogicielId("Librairie1",version2),"Test lib1 Description",new URL("https://lib.librairies.org"));
            Librairie lib2 = new Librairie(new LogicielId("Librairie2",version1),"Test lib2 Description",new URL("https://lib.librairies.org"));
            Librairie lib3 = new Librairie(new LogicielId("Librairie3",version2),"Test lib3 Description",new URL("https://lib.librairies.org"));
            Librairie lib4 = new Librairie(new LogicielId("Librairie4",version1),"Test lib4 Description",new URL("https://lib.librairies.org"));

            this.libr.saveAll(List.of(lib1,lib2,lib3,lib4));

            lib1.setLibrairies(Arrays.asList(lib2,lib3));
            lib2.setLibrairies(Arrays.asList(lib1,lib4));

            this.libr.saveAllAndFlush(List.of(lib1,lib2,lib3,lib4));

            System.out.println(this.libr.findAll());

            System.out.println(lib1.getLibrairies());
            System.out.println(lib2.getLibrairies());

            //Test composant class
            Composant cp1 = new Composant(new ComposantId("code1",version1),"cp1 description", new URL("https://cp1.org"));
            Composant cp2 = new Composant(new ComposantId("code2",version2),"cp2 description", new URL("https://cp2.org"));
            Composant cp3 = new Composant(new ComposantId("code3",version2),"cp3 description", new URL("https://cp3.org"));

            this.cpr.saveAll(List.of(cp1, cp2, cp3));
            cp1.setLogicielCp(logiciel1);
            cp2.setLogicielCp(logiciel1);
            cp3.setLogicielCp(logiciel2);
            System.out.println(logiciel1.getComposants());
            System.out.println(logiciel2.getComposants());

            System.out.println(this.cpr.findAll());

            //Test License class
            License lis1 = new License(new LicenseId("lis1","fr",version1),"Long text description of license 1");
            License lis2 = new License(new LicenseId("lis2","en",version2),"Long text description of license 2");
            License lis3 = new License(new LicenseId("lis3","en",version2),"Long text description of license 3");

            this.lisr.saveAll(List.of(lis1,lis2,lis3));

            lis1.setComposantsLicense(List.of(cp1,cp2));
            lis2.setComposantsLicense(List.of(cp2,cp3));
            lis3.setComposantsLicense(List.of(cp1,cp2,cp3));

            lis1.setLogicielsLicense(List.of(logiciel1,logiciel2));
            lis2.setLogicielsLicense(List.of(logiciel1,logiciel3));
            lis3.setLogicielsLicense(List.of(logiciel1,logiciel2,logiciel3));

            System.out.println("Composants de lisence 1 :"+lis1.getComposantsLicense());
            System.out.println("Composants de lisence 2 :"+lis2.getComposantsLicense());
            System.out.println("Composants de lisence 3 :"+lis3.getComposantsLicense());

            System.out.println(this.lisr.findAll());

            //Creation des comptes :
            Compte admin = new Compte("mohamed@gmail.com","admin");
            admin.setUserRole(UserRole.ADMIN);

            Compte normal = new Compte("test@gmail.com","user");
            normal.setUserRole(UserRole.USER);

            this.userService.signUpUser(admin);
            this.userService.signUpUser(normal);

            this.userService.getCompteList().forEach(System.out::println);
        };
    }
}

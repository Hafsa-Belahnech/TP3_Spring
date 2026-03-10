package presentation;

import metier.IMetier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = {"dao","metier","config"})
public class Presentation2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        // Choix 1 pour les profils : on décommente un profil pour le tester
        //ctx.getEnvironment().setActiveProfiles("dev");  //400
        //ctx.getEnvironment().setActiveProfiles("prod"); //560
        //ctx.getEnvironment().setActiveProfiles("file");  //600
        // ctx.getEnvironment().setActiveProfiles("api"); //444

        // Choix 2 pour propriété externe: on laisse les profils vides
        // PropertyDrivenConfig créera ainsi un bean "dao" selon app.properties

        ctx.register(Presentation2.class);
        ctx.refresh();

        IMetier metier = ctx.getBean(IMetier.class);
        System.out.println("Résultat = " + metier.calcul());
        ctx.close();
    }
}

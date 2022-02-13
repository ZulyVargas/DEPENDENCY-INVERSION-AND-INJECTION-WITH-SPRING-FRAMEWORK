package edu.eci.arsw.blueprints.services;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String a[]) throws BlueprintPersistenceException, BlueprintNotFoundException {

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bps = ac.getBean(BlueprintsServices.class);
        bps.addNewBlueprint(new Blueprint("zuly", "firstPrint", new Point[]{new Point(45,45), new Point(65,75)}));
        bps.addNewBlueprint(new Blueprint("jose", "secondPrint", new Point[]{new Point(35,35), new Point(75,75)}));
        bps.addNewBlueprint(new Blueprint("zuly", "thirdPrint", new Point[]{new Point(23,23), new Point(46,35)}));
        System.out.println(bps.getAllBlueprints());
        System.out.println(bps.getBlueprintsByAuthor("zuly"));

    }

}
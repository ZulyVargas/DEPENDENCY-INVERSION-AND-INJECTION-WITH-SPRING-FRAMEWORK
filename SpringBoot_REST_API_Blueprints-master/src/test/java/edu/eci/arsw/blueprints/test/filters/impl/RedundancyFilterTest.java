package edu.eci.arsw.blueprints.test.filters.impl;

import edu.eci.arsw.blueprints.filters.impl.RedundancyFilter;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.impl.InMemoryBlueprintPersistence;

import java.sql.Array;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

public class RedundancyFilterTest {

    @Test
    public void shouldApplyRedundancyFilterInBlueprint() throws BlueprintPersistenceException, BlueprintNotFoundException {
        RedundancyFilter rf = new RedundancyFilter();

        Point[] pts0=new Point[]{new Point(40, 40),new Point(40, 40),new Point(44, 47),new Point(60, 70), new Point(80, 47),new Point(80, 47) };
        Blueprint bp0=new Blueprint("jim", "jimPaint",pts0);

        assertEquals(4, rf.filterBlueprint(bp0).getPoints().size());

    }
    @Test
    public void shouldApplyRedundancyFilterInBlueprints() throws BlueprintPersistenceException, BlueprintNotFoundException {
        RedundancyFilter rf = new RedundancyFilter();

        Point[] pts0=new Point[]{new Point(40, 40),new Point(40, 40),new Point(44, 47),new Point(60, 70), new Point(80, 47),new Point(80, 47) };
        Point[] pts1=new Point[]{new Point(30, 40),new Point(40, 40),new Point(24, 47),new Point(24, 47), new Point(80, 47),new Point(80, 47) };
        Point[] pts2=new Point[]{new Point(24, 402),new Point(24, 402),new Point(24, 47),new Point(24, 47), new Point(10, 67),new Point(70, 47),new Point(70, 47) };

        Blueprint bp0=new Blueprint("jim", "jimPaint",pts0);
        Blueprint bp1=new Blueprint("jon", "jonPaint",pts1);
        Blueprint bp2=new Blueprint("jan", "janPaint",pts2);

        Set<Blueprint> blueprints = new HashSet<Blueprint>();

        blueprints.add(bp0);
        blueprints.add(bp1);
        blueprints.add(bp2);

        rf.filterBlueprints(blueprints);
        for (Blueprint bp : blueprints) {
            assertEquals(4,bp.getPoints().size() );
        }
    }
}

package edu.eci.arsw.blueprints.test.filters.impl;

import edu.eci.arsw.blueprints.filters.impl.RedundancyFilter;
import edu.eci.arsw.blueprints.filters.impl.SubsamplingFilter;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SubsamplingFilterTest {

    @Test
    public void shouldApplyRedundancyFilterInBlueprint() throws BlueprintPersistenceException, BlueprintNotFoundException {
        SubsamplingFilter sf = new SubsamplingFilter();

        Point[] pts0=new Point[]{new Point(40, 40),new Point(40, 40),new Point(44, 47),new Point(60, 70), new Point(80, 47),new Point(80, 47) };
        Blueprint bp0=new Blueprint("jim", "jimPaint",pts0);

        assertEquals(3, sf.filterBlueprint(bp0).getPoints().size());
    }

    @Test
    public void shouldApplyRedundancyFilterInBlueprints() throws BlueprintPersistenceException, BlueprintNotFoundException {
        SubsamplingFilter sf = new SubsamplingFilter();

        Point[] pts0=new Point[]{new Point(40, 40),new Point(40, 40),new Point(44, 47),new Point(60, 70), new Point(80, 47),new Point(80, 47) };
        Point[] pts1=new Point[]{new Point(30, 40),new Point(40, 40),new Point(24, 47),new Point(24, 47), new Point(80, 47),new Point(80, 47) };
        Point[] pts2=new Point[]{new Point(24, 402),new Point(24, 402),new Point(24, 47),new Point(24, 47), new Point(10, 67),new Point(70, 47) };


        Blueprint bp0=new Blueprint("jim", "jimPaint",pts0);
        Blueprint bp1=new Blueprint("jon", "jonPaint",pts1);
        Blueprint bp2=new Blueprint("jan", "janPaint",pts2);

        Set<Blueprint> blueprints = new HashSet<Blueprint>();

        blueprints.add(bp0);
        blueprints.add(bp1);
        blueprints.add(bp2);

        sf.filterBlueprints(blueprints);
        for (Blueprint bp : blueprints) {
            assertEquals(3,bp.getPoints().size() );
        }
    }


}

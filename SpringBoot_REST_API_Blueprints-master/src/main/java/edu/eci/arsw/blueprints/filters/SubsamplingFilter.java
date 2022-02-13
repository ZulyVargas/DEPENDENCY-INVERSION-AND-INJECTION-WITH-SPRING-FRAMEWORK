package edu.eci.arsw.blueprints.filters;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.impl.InMemoryBlueprintPersistence;
import org.springframework.stereotype.Component;

import java.util.Set;

//@Component
public class SubsamplingFilter implements BlueprintsFilters{

    @Override
    public Set<Blueprint> filter(Set<Blueprint> blueprints) {
        return null;
    }
}

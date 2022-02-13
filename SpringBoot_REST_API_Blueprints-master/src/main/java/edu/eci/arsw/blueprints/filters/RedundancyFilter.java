package edu.eci.arsw.blueprints.filters;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.impl.InMemoryBlueprintPersistence;

import java.util.Set;

//@Component
public class RedundancyFilter implements BlueprintsFilters{

    @Override
    public Set<Blueprint> filter(Set<Blueprint> blueprints) {
        return null;
    }
}

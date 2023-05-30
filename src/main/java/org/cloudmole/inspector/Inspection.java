package org.cloudmole.inspector;

import jakarta.annotation.PostConstruct;
import org.cloudmole.inspector.database.AWSDatabaseInspector;
import org.cloudmole.inspector.generic.database.DatabaseInspector;
import org.springframework.stereotype.Component;

@Component
public class Inspection {
    @PostConstruct
    public void run() {
        DatabaseInspector databaseInspector = new AWSDatabaseInspector();
        databaseInspector.findDatabases();
    }
}

package org.cloudmole.inspector;

import jakarta.annotation.PostConstruct;
import org.cloudmole.inspector.database.AWSDatabaseInspector;
import org.cloudmole.inspector.generic.CloudServiceFactory;
import org.cloudmole.inspector.generic.database.DatabaseInspector;
import org.cloudmole.inspector.model.CloudProvider;
import org.cloudmole.inspector.model.CloudService;
import org.cloudmole.inspector.model.CloudServiceType;
import org.cloudmole.inspector.model.Environment;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.regions.Region;

import java.util.List;

@Component
public class Inspection {
    @PostConstruct
    public void run() {
        Environment environment = new Environment().cloudServices(
                List.of((new CloudService()
                        .cloudProvider(CloudProvider.AWS)
                        .cloudServiceType(CloudServiceType.DATABASE)
                        .profile("codemole")
                        .region(Region.US_WEST_2.id())
                        )
                ));

        environment.cloudServices().forEach(s -> {
            CloudServiceFactory.getInstacne().getInspector(s).execute(s);
        });

    }
}

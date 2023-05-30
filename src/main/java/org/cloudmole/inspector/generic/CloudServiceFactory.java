package org.cloudmole.inspector.generic;

import org.cloudmole.inspector.database.AWSDatabaseInspector;
import org.cloudmole.inspector.model.CloudProvider;
import org.cloudmole.inspector.model.CloudService;
import org.cloudmole.inspector.model.CloudServiceType;

public class CloudServiceFactory {
    private static CloudServiceFactory instance;

    private CloudServiceFactory() {

    }

    public static CloudServiceFactory getInstacne() {
        if (instance == null)
            instance = new CloudServiceFactory();
        return instance;
    }

    public CloudInspector getInspector(CloudService cloudService){
        if (CloudProvider.AWS.equals(cloudService.cloudProvider())) {
            if (CloudServiceType.DATABASE.equals(cloudService.cloudServiceType()))
                return new AWSDatabaseInspector();
        }

        throw new IllegalArgumentException("No inspector found for given params");
    }
}

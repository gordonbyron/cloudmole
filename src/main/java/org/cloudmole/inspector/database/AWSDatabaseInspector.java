package org.cloudmole.inspector.database;

import org.cloudmole.inspector.generic.database.DatabaseInspector;
import org.cloudmole.inspector.model.Database;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.rds.RdsClient;
import software.amazon.awssdk.services.rds.model.DBInstance;
import software.amazon.awssdk.services.rds.model.DescribeDbInstancesResponse;
import software.amazon.awssdk.services.rds.model.RdsException;

import java.util.List;
import java.util.Set;

public class AWSDatabaseInspector implements DatabaseInspector {
    @Override
    public void execute() {

    }

    @Override
    public Set<Database> findDatabases() {
        try (RdsClient rdsClient = RdsClient.builder()
                .region(Region.US_WEST_2)
                .credentialsProvider(ProfileCredentialsProvider.create("codemole"))
                .build()) {
            
            try {
                DescribeDbInstancesResponse response = rdsClient.describeDBInstances();
                List<DBInstance> instanceList = response.dbInstances();
                for (DBInstance instance: instanceList) {
                    System.out.println("Instance ARN is: "+instance.dbInstanceArn());
                    System.out.println("The Engine is " +instance.engine());
                    System.out.println("Connection endpoint is" +instance.endpoint().address());
                }

            } catch (RdsException e) {
                System.out.println(e.getLocalizedMessage());
                System.exit(1);
            }
        }


        return null;
    }
}

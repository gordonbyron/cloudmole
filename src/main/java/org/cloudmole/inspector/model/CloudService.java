package org.cloudmole.inspector.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true, chain = true)
public class CloudService {
    private CloudServiceType cloudServiceType;
    private CloudProvider cloudProvider;
    private String profile;
    private String region;
}

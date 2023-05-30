package org.cloudmole.inspector.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
@Accessors(fluent = true, chain = true)
@Getter
@Setter
public class Environment {
    private List<CloudService> cloudServices = new ArrayList();
}

package org.cloudmole.inspector.generic;

import org.cloudmole.inspector.model.CloudService;

import java.util.List;

public abstract interface CloudInspector<T> {
    abstract List<T> execute(CloudService cloudService);
}

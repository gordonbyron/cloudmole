package org.cloudmole.inspector.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Database {
    private UUID id;
    private String name;
    private String host;
}

package ru.aplk.management.additions.types.functions;

import java.util.List;

public interface FindAll<ObjectType> {
    List<ObjectType> apply();
}

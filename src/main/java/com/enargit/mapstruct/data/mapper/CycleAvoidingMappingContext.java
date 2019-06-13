package com.enargit.mapstruct.data.mapper;

import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.TargetType;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.IdentityHashMap;
import java.util.Map;


@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CycleAvoidingMappingContext {

    private Map<Object, Object> knownInstances = new IdentityHashMap<>();


    @SuppressWarnings("unchecked")
    @BeforeMapping
    public <T> T getMappedInstance(final Object source, @TargetType final Class<T> targetType) {
        return (T) knownInstances.get(source);
    }

    @BeforeMapping
    public void storeMappedInstance(final Object source, @TargetType final Object target) {
        knownInstances.put(source, target);
    }
}

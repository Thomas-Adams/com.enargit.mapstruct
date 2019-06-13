package com.enargit.mapstruct.data.mapper;

import com.enargit.mapstruct.data.dto.TodoDto;
import com.enargit.mapstruct.data.entities.TodoEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface TodoMapper {

    TodoMapper INSTANCE = Mappers.getMapper(TodoMapper.class);

    @Mappings({
            @Mapping(source = "categoryEntities", target = "categoryDtos")
    })
    TodoDto toTodoDto(TodoEntity todoEntity, @Context CycleAvoidingMappingContext cycleContext);

    @Mappings({
            @Mapping(target = "categoryEntities", source = "categoryDtos")
    })
    TodoEntity toTodoEntity(TodoDto todoDto, @Context CycleAvoidingMappingContext cycleContext);


    Set<TodoDto> toTodoDto(Set<TodoEntity> todoEntity, @Context CycleAvoidingMappingContext cycleContext);


    Set<TodoEntity> toTodoEntity(Set<TodoDto> todoDto, @Context CycleAvoidingMappingContext cycleContext);

}

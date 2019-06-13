package com.enargit.mapstruct.data.mapper;


import com.enargit.mapstruct.data.dto.CategoryDto;
import com.enargit.mapstruct.data.dto.TodoDto;
import com.enargit.mapstruct.data.entities.CategoryEntity;
import com.enargit.mapstruct.data.entities.TodoEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface CategoryMapper {


    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mappings({
            @Mapping(source = "todoEntity", target = "todoDto")
    })
    CategoryDto toCategoryDto(CategoryEntity categoryEntity, @Context CycleAvoidingMappingContext cycleContext);

    @Mappings({
            @Mapping(target = "todoEntity", source = "todoDto")
    })
    CategoryEntity toCategoryEntity(CategoryDto categoryDto, @Context CycleAvoidingMappingContext cycleContext);


    Set<CategoryDto> toCategoryDto(Set<CategoryEntity> categoryEntity, @Context CycleAvoidingMappingContext cycleContext);

    Set<CategoryEntity> toCategoryEntity(Set<CategoryDto> categoryDto, @Context CycleAvoidingMappingContext cycleContext);

}

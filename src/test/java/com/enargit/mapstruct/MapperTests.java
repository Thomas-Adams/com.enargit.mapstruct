package com.enargit.mapstruct;


import com.enargit.mapstruct.data.dto.CategoryDto;
import com.enargit.mapstruct.data.dto.TodoDto;
import com.enargit.mapstruct.data.entities.CategoryEntity;
import com.enargit.mapstruct.data.entities.TodoEntity;
import com.enargit.mapstruct.data.mapper.CategoryMapper;
import com.enargit.mapstruct.data.mapper.CycleAvoidingMappingContext;
import com.enargit.mapstruct.data.mapper.TodoMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


public class MapperTests {

    @Test
    public void testCategoryMapper() {

        CategoryEntity ce = CategoryEntity.builder().id(1).name("Sports").build();
        Assert.assertEquals(1, ce.getId());
        Assert.assertEquals("Sports", ce.getName());

        CycleAvoidingMappingContext cycleAvoidingMappingContext = new CycleAvoidingMappingContext();
        CategoryDto co = CategoryMapper.INSTANCE.toCategoryDto(ce, cycleAvoidingMappingContext);
        Assert.assertEquals(1, co.getId());
        Assert.assertEquals("Sports", co.getName());
    }


    @Test
    public void testTodoMapper() {


        Set<CategoryEntity> categoryEntities = new HashSet<>(0);
        CategoryEntity cat1 = CategoryEntity.builder().id(1).name("Category 1").build();
        categoryEntities.add(cat1);

        TodoEntity ce = TodoEntity.builder().id(1).title("Sports").categoryEntities(categoryEntities).build();
        Assert.assertEquals(1, ce.getId());
        Assert.assertEquals("Sports", ce.getTitle());

        CycleAvoidingMappingContext cycleAvoidingMappingContext = new CycleAvoidingMappingContext();
        TodoDto co = TodoMapper.INSTANCE.toTodoDto(ce, cycleAvoidingMappingContext);
        Assert.assertEquals(1, co.getId());
        Assert.assertEquals("Sports", co.getTitle());
        Assert.assertNotNull( co.getCategoryDtos());
        Assert.assertEquals(1, co.getCategoryDtos().size());

    }

}

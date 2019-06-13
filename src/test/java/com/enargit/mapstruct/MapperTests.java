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


public class MapperTests {


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

        TodoEntity ce = TodoEntity.builder().id(1).title("Sports").categoryEntities(new HashSet<>(0)).build();
        Assert.assertEquals(1, ce.getId());
        Assert.assertEquals("Sports", ce.getTitle());

        CycleAvoidingMappingContext cycleAvoidingMappingContext = new CycleAvoidingMappingContext();
        TodoDto co = TodoMapper.INSTANCE.toTodoDto(ce, cycleAvoidingMappingContext);
        Assert.assertEquals(1, co.getId());
        Assert.assertEquals("Sports", co.getTitle());
        Assert.assertNotNull( co.getTitle());
    }

}

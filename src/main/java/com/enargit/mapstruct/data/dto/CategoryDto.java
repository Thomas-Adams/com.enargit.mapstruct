package com.enargit.mapstruct.data.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDto {


    private long id;

    private long version;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modified;

    private String name;

    private String description;

    private TodoDto todoDto;


    public static final class Builder {
        private long id;
        private long version;
        private Date created;
        private Date modified;
        private String name;
        private String description;
        private TodoDto todoDto;

        private Builder() {
        }

        public static CategoryDto.Builder aCategoryDto() {
            return new Builder();
        }

        public CategoryDto.Builder id(long id) {
            this.id = id;
            return this;
        }

        public CategoryDto.Builder version(long version) {
            this.version = version;
            return this;
        }

        public CategoryDto.Builder created(Date created) {
            this.created = created;
            return this;
        }

        public CategoryDto.Builder modified(Date modified) {
            this.modified = modified;
            return this;
        }

        public CategoryDto.Builder name(String name) {
            this.name = name;
            return this;
        }

        public CategoryDto.Builder description(String description) {
            this.description = description;
            return this;
        }

        public CategoryDto.Builder TodoDto(TodoDto todoDto) {
            this.todoDto = todoDto;
            return this;
        }

        public CategoryDto build() {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(id);
            categoryDto.setVersion(version);
            categoryDto.setCreated(created);
            categoryDto.setModified(modified);
            categoryDto.setName(name);
            categoryDto.setDescription(description);
            categoryDto.setTodoDto(todoDto);
            return categoryDto;
        }
    }

    public static CategoryDto.Builder builder() {
        return Builder.aCategoryDto();
    }
}

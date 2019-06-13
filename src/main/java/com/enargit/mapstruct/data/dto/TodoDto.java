package com.enargit.mapstruct.data.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class TodoDto {


    private long id;

    private long version;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modified;


    private String title;

    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date due;

    private Set<CategoryDto> categoryDtos = new HashSet<>(0);


    public static final class Builder {
        private long id;
        private long version;
        private Date created;
        private Date modified;
        private String title;
        private String description;
        private Date due;
        private Set<CategoryDto> categoryDtos = new HashSet<>(0);

        private Builder() {
        }

        public static Builder aTodoDto() {
            return new Builder();
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder version(long version) {
            this.version = version;
            return this;
        }

        public Builder created(Date created) {
            this.created = created;
            return this;
        }

        public Builder modified(Date modified) {
            this.modified = modified;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder due(Date due) {
            this.due = due;
            return this;
        }

        public Builder categoryDtos(Set<CategoryDto> categoryDtos) {
            this.categoryDtos = categoryDtos;
            return this;
        }

        public TodoDto build() {
            TodoDto todoDto = new TodoDto();
            todoDto.setId(id);
            todoDto.setVersion(version);
            todoDto.setCreated(created);
            todoDto.setModified(modified);
            todoDto.setTitle(title);
            todoDto.setDescription(description);
            todoDto.setDue(due);
            todoDto.setCategoryDtos(categoryDtos);
            return todoDto;
        }
    }

    public static Builder builder() {
        return Builder.aTodoDto();
    }
}

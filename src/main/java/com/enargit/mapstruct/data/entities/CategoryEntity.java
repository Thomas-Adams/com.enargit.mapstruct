package com.enargit.mapstruct.data.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "category")
public class CategoryEntity {


    @Id
    private long id;

    @Version
    private long version;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date created;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date modified;


    @Column(unique = true)
    private String name;

    @Column
    private String description;

    @Column
    @ManyToOne
    private TodoEntity todoEntity;


    public static final class Builder {
        private long id;
        private long version;
        private Date created;
        private Date modified;
        private String name;
        private String description;
        private TodoEntity todoEntity;

        private Builder() {
        }

        public static Builder aCategoryEntity() {
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

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder todoEntity(TodoEntity todoEntity) {
            this.todoEntity = todoEntity;
            return this;
        }

        public CategoryEntity build() {
            CategoryEntity categoryEntity = new CategoryEntity();
            categoryEntity.setId(id);
            categoryEntity.setVersion(version);
            categoryEntity.setCreated(created);
            categoryEntity.setModified(modified);
            categoryEntity.setName(name);
            categoryEntity.setDescription(description);
            categoryEntity.setTodoEntity(todoEntity);
            return categoryEntity;
        }
    }

    public static Builder builder() {
        return Builder.aCategoryEntity();
    }

}

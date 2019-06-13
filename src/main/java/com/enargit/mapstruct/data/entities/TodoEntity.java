package com.enargit.mapstruct.data.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "todo")
public class TodoEntity {


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
    private String title;

    @Column
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date due;

    @OneToMany(mappedBy = "todoEntity")
    private Set<CategoryEntity> categoryEntities = new HashSet<>(0);


    public static final class Builder {
        private long id;
        private long version;
        private Date created;
        private Date modified;
        private String title;
        private String description;
        private Date due;
        private Set<CategoryEntity> categoryEntities = new HashSet<>(0);

        private Builder() {
        }

        public static Builder aTodoEntity() {
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

        public Builder categoryEntities(Set<CategoryEntity> categoryEntities) {
            this.categoryEntities = categoryEntities;
            return this;
        }

        public TodoEntity build() {
            TodoEntity todoEntity = new TodoEntity();
            todoEntity.setId(id);
            todoEntity.setVersion(version);
            todoEntity.setCreated(created);
            todoEntity.setModified(modified);
            todoEntity.setTitle(title);
            todoEntity.setDescription(description);
            todoEntity.setDue(due);
            todoEntity.setCategoryEntities(categoryEntities);
            return todoEntity;
        }
    }

    public static Builder builder() {
        return Builder.aTodoEntity();
    }
}

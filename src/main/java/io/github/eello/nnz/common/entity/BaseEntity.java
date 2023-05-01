package io.github.eello.nnz.common.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

    @CreatedBy
    private Long createBy;

    @CreatedDate
    private LocalDateTime createAt;

    @LastModifiedBy
    private Long updatedBy;

    @LastModifiedDate
    private LocalDateTime updatedAy;

    public Long getCreateBy() {
        return createBy;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public LocalDateTime getUpdatedAy() {
        return updatedAy;
    }
}

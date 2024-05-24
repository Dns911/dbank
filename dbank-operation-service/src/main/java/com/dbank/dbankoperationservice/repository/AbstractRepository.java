package com.dbank.dbankoperationservice.repository;

import com.dbank.dbankoperationservice.entity.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbstractRepository<T extends AbstractEntity> extends JpaRepository<T, Long> {
}

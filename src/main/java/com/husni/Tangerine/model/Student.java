package com.husni.Tangerine.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
public record Student(
    @Id
    Integer id,
    String name,
    Integer age
) {
    
}

package com.projectmanager.backend.dto;

public class ColumnResponse {

    private Long id;
    private String name;
    private Integer position;

    public ColumnResponse(Long id, String name, Integer position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }
}
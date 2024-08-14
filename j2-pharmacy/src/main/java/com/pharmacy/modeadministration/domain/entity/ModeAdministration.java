package com.pharmacy.modeadministration.domain.entity;

import java.text.MessageFormat;

public class ModeAdministration {
    private Long id;
    private String descriptionmode;
    

    public ModeAdministration() {
    }
    public ModeAdministration(Long id, String descriptionmode) {
        this.id = id;
        this.descriptionmode = descriptionmode;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescriptionmode() {
        return descriptionmode;
    }
    public void setDescriptionmode(String descriptionmode) {
        this.descriptionmode = descriptionmode;
    }

    @Override
    public String toString() {
        String data = MessageFormat.format("Id: {0}\nName: {1}", this.id, this.descriptionmode);
        return data;
    }
}

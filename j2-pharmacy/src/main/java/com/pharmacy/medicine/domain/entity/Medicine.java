package com.pharmacy.medicine.domain.entity;

import java.text.MessageFormat;

public class Medicine {
    private Long id;
    private String proceedings;
    private String nameMedicine;
    private String healthRegister;
    private String description;
    private String descriptionShort;
    private String nameRol;
    private Long codeModeAdmin;
    private Long codeAp;
    private Long codeUm;
    private Long codeLab;

    public Medicine() {
    }
    public Medicine(Long id, String proceedings, String nameMedicine, String healthRegister, String description, String descriptionShort, String nameRol, Long codeModeAdmin, Long codeAp, Long codeUm, Long codeLab)  {
        this.id = id;
        this.proceedings = proceedings;
        this.nameMedicine = nameMedicine;
        this.healthRegister = healthRegister;
        this.description = description;
        this.descriptionShort = descriptionShort;
        this.nameRol = nameRol;
        this.codeModeAdmin = codeModeAdmin;
        this.codeAp = codeAp;
        this.codeUm = codeUm;
        this.codeLab = codeLab;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getProceedings() {
        return proceedings;
    }
    public void setProceedings(String proceedings) {
        this.proceedings = proceedings;
    }
    public String getNameMedicine() {
        return nameMedicine;
    }
    public void setNameMedicine(String nameMedicine) {
        this.nameMedicine = nameMedicine;
    }
    public String getHealthRegister() {
        return healthRegister;
    }
    public void setHealthRegister(String healthRegister) {
        this.healthRegister = healthRegister;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescriptionShort() {
        return descriptionShort;
    }
    public void setDescriptionShort(String descriptionShort) {
        this.descriptionShort = descriptionShort;
    }
    public String getNameRol() {
        return nameRol;
    }
    public void setNameRol(String nameRol) {
        this.nameRol = nameRol;
    }
    public Long getCodeModeAdmin() {
        return codeModeAdmin;
    }
    public void setCodeModeAdmin(Long codeModeAdmin) {
        this.codeModeAdmin = codeModeAdmin;
    }
    public Long getCodeAp() {
        return codeAp;
    }
    public void setCodeAp(Long codeAp) {
        this.codeAp = codeAp;
    }
    public Long getCodeUm() {
        return codeUm;
    }
    public void setCodeUm(Long codeUm) {
        this.codeUm = codeUm;
    }
    public Long getCodeLab() {
        return codeLab;
    }
    public void setCodeLab(Long codeLab) {
        this.codeLab = codeLab;
    }

    @Override
    public String toString() {
        String data = MessageFormat.format("Id: {0}\nProceedings: {1}\nName: {2}\nHealth Register: {3}\nDescription: {4}\nShorter Description: {5}\nRole Name: {6}\nMode Administrator Code: {7}\nActive Principle Code: {8}\nUnit Measurement Code: {9}\nLaboratory Code: {10}", this.id, this.proceedings, this.nameMedicine, this.healthRegister, this.description, this.descriptionShort, this.nameRol, this.codeModeAdmin, this.codeAp, this.codeUm, this.codeLab);
        return data;
    }
}

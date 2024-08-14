package com.pharmacy;

import javax.swing.JOptionPane;

import com.pharmacy.activeprinciple.infrastructure.controller.ActivePrincipleController;
import com.pharmacy.country.infrastructure.controller.CountryController;
import com.pharmacy.modeadministration.infrastructure.Controller.ModeAdministrationController;
import com.pharmacy.region.infrastructure.controller.RegionController;



public class Main {
    public static void main(String[] args) {

        String opciones = "1. Administration Mode Module\n2. Active Principle Module\n3. Country Module\n4. Region Module\n5. Exit";
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, opciones));
            switch (op) {
                case 1:
                    ModeAdministrationController modeAdminAdapter = new ModeAdministrationController();
                    modeAdminAdapter.modeAdministrationMenu();
                    break;
                case 2:
                    ActivePrincipleController activePrincipleAdapter = new ActivePrincipleController();
                    activePrincipleAdapter.activePrincipleMenu();
                    break;
                case 3:
                    CountryController countryAdapter = new CountryController();
                    countryAdapter.countryMenu();
                    break;
                case 4:
                    RegionController regionAdapter = new RegionController();
                    regionAdapter.regionMenu();
                case 5:
                    JOptionPane.showMessageDialog(null, "Suerte no vemos.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error opcion invalida.");
                    break;
            }
        } while(op!=5);
    }
}
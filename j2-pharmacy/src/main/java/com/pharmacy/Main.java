package com.pharmacy;

import javax.swing.JOptionPane;

import com.pharmacy.modeadministration.infrastructure.Controller.ModeAdministrationController;



public class Main {
    public static void main(String[] args) {

        String opciones = "1. Administration Mode Module\n2. Exit";
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, opciones));
            switch (op) {
                case 1:
                    ModeAdministrationController consoleAdapter = new ModeAdministrationController();
                    consoleAdapter.modeAdministrationMenu();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Suerte no vemos.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error opcion invalida.");
                    break;
            }

        } while(op!=2);
    }
}
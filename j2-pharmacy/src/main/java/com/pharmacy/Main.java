package com.pharmacy;

import javax.swing.JOptionPane;

import com.pharmacy.activeprinciple.infrastructure.controller.ActivePrincipleController;
import com.pharmacy.city.infrastructure.controller.CityController;
import com.pharmacy.country.infrastructure.controller.CountryController;
import com.pharmacy.customer.infrastructure.controller.CustomerController;
import com.pharmacy.laboratory.infrastructure.controller.LaboratoryController;
import com.pharmacy.modeadministration.infrastructure.Controller.ModeAdministrationController;
import com.pharmacy.pharmacy.infrastructure.controller.PharmacyController;
import com.pharmacy.pharmacymedicine.infrastructure.controller.PharmacyMedicineController;
import com.pharmacy.region.infrastructure.controller.RegionController;
import com.pharmacy.unitmeasurement.infrastructure.controller.UnitMeasurementController;



public class Main {
    public static void main(String[] args) {

        String opciones = "1. Administration Mode Module\n2. Active Principle Module\n3. Country Module\n4. Region Module\n5. City Module\n6. Customer Module\n7. Exit";
        int op;
        try {
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
                        break;
                    case 5:
                        CityController cityAdapter = new CityController();
                        cityAdapter.cityMenu();
                        break;
                    case 6:
                        CustomerController customerAdapter = new CustomerController();
                        customerAdapter.customerMenu();
                        break;
                    case 7:
                        LaboratoryController laboratoryAdapter = new LaboratoryController();
                        laboratoryAdapter.laboratoryMenu();
                        break;
                    case 8:
                        UnitMeasurementController unitMeasurementAdapter = new UnitMeasurementController();
                        unitMeasurementAdapter.unitMeasurementMenu();
                        break;
                    case 9:
                        PharmacyController pharmacyAdapter = new PharmacyController();
                        pharmacyAdapter.pharmacyMenu();
                        break;
                    case 10:
                        PharmacyMedicineController pharmacyMedicineAdapter = new PharmacyMedicineController();
                        pharmacyMedicineAdapter.pharmacyMedicineMenu();
                        break;
                    case 11:
                        JOptionPane.showMessageDialog(null, "Suerte no vemos.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Error opcion invalida.");
                }
            }  while(op!=8);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
}
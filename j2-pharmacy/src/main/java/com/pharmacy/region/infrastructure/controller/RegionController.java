package com.pharmacy.region.infrastructure.controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.pharmacy.region.application.CreateRegionUseCase;
import com.pharmacy.region.application.DeleteRegionUseCase;
import com.pharmacy.region.application.FindRegionUseCase;
import com.pharmacy.region.application.UpdateRegionUseCase;
import com.pharmacy.region.domain.entity.Region;
import com.pharmacy.region.domain.service.RegionService;
import com.pharmacy.region.infrastructure.repository.RegionRepository;

public class RegionController {
    RegionService regionService;
    CreateRegionUseCase createRegionUseCase;
    FindRegionUseCase findRegionUseCase;
    UpdateRegionUseCase updateRegionUseCase;
    DeleteRegionUseCase deleteRegionUseCase;

    public RegionController() {
        regionService = new RegionRepository();
        createRegionUseCase = new CreateRegionUseCase(regionService);
        findRegionUseCase = new FindRegionUseCase(regionService);
        updateRegionUseCase = new UpdateRegionUseCase(regionService);
        deleteRegionUseCase = new DeleteRegionUseCase(regionService);
    }

    public void regionMenu() {
        String opciones = "1. Add Region\n2. Search Region\n3. Update Region\n4. Delete Region\n5. Exit";
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, opciones));
            switch (op) {
                case 1:
                    addRegion();
                    break;
                case 2:
                    searchRegion();
                    break;
                case 3:
                    amendRegion();
                    break;
                case 4:
                    removeRegion();
                    break;
                case 5:
                    break;
                default:
                JOptionPane.showMessageDialog(null, "Error opcion invalida", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while(op!=5);
    }

    public void addRegion() {
        String id = JOptionPane.showInputDialog(null, "Add Region Code");
        String name = JOptionPane.showInputDialog(null, "Add Name");
        String code = JOptionPane.showInputDialog(null, "Add Country Code");
        Region region = new Region();
        region.setCodeReg(id);
        region.setNameReg(name);
        region.setCodeCountry(code);
        createRegionUseCase.execute(region);
        System.out.println("Region created successfully");
    }

    public void searchRegion() {
        try {
            String id = JOptionPane.showInputDialog(null, "Enter Region ID: ");
            findRegionUseCase.execute(id).ifPresentOrElse(foundRegion -> {
                JOptionPane.showMessageDialog(null, foundRegion.toString());
                foundRegion.toString();
            }, () -> {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void amendRegion() {
        JPanel panel = new JPanel();

        JTextField idField = new JTextField(10);
        JTextField nameField = new JTextField(10);
        JTextField codeField = new JTextField(10);

        panel.add(new JLabel("Region ID:"));
        panel.add(idField);
        panel.add(new JLabel("Region Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Country Code: "));
        panel.add(codeField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Mode Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String id = idField.getText();
                String code = codeField.getText();
                String name= nameField.getText();

                updateRegionUseCase.execute(id, name, code).ifPresentOrElse(updatedRegion -> {
                    JOptionPane.showMessageDialog(null, updatedRegion.toString());
                }, () -> {
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void removeRegion() {
        try {
            String id = JOptionPane.showInputDialog(null, "Enter Region ID: ");
            deleteRegionUseCase.execute(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

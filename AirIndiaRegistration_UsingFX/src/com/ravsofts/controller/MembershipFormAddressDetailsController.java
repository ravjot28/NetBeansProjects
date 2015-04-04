/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravsofts.controller;

import com.ravsofts.constants.GlobalConstants;
import com.ravsofts.dao.AddressDetails;
import com.ravsofts.ui.ScreenController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Dialogs;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ravjot
 */
public class MembershipFormAddressDetailsController implements Initializable, ControlledScreen {

    ScreenController myController;
    @FXML
    TextField pinCode;
    @FXML
    TextField state;
    @FXML
    TextField city;
    @FXML
    TextArea address;
    AddressDetails addressDetails = new AddressDetails();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Bindings.bindBidirectional(address.textProperty(), addressDetails.addressProperty());
        Bindings.bindBidirectional(city.textProperty(), addressDetails.cityProperty());
        Bindings.bindBidirectional(state.textProperty(), addressDetails.stateProperty());
        Bindings.bindBidirectional(pinCode.textProperty(), addressDetails.pinCodeProperty());
    }

    @Override
    public void setScreenParent(ScreenController screenPage) {
        myController = screenPage;
    }

    @FXML
    public void moveToEmployeeDetailsPage() {
        myController.setScreen(GlobalConstants.employeeDetailsScreen);
    }

    @FXML
    public void moveToContactDetailsPage() throws IOException {
        String address = addressDetails.getAddress();
        String city = addressDetails.getCity();
        String pinCode = addressDetails.getPinCode();
        String state = addressDetails.getState();

        if (address == null || address.trim().length() == 0) {
            Dialogs.showErrorDialog(null, null, GlobalConstants.invalidAddressFieldMessage, GlobalConstants.ERROR);
        } else if (city == null || city.trim().length() == 0) {
            Dialogs.showErrorDialog(null, null, GlobalConstants.invalidCityFieldMessage, GlobalConstants.ERROR);
        } else if (pinCode == null || pinCode.trim().length() == 0) {
            Dialogs.showErrorDialog(null, null, GlobalConstants.invalidPinCodeFieldMessage, GlobalConstants.ERROR);
        } else if (state == null || state.trim().length() == 0) {
            Dialogs.showErrorDialog(null, null, GlobalConstants.invalidStateFieldMessage, GlobalConstants.ERROR);
        } else {
            myController.setScreen(GlobalConstants.contactDetailsScreen);
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravsofts.controller.edit;

import com.ravsofts.constants.GlobalConstants;
import com.ravsofts.controller.ControlledScreen;
import com.ravsofts.dao.ContactInfo;
import com.ravsofts.dao.MembershipInfo;
import com.ravsofts.dao.NomineeDetails;
import com.ravsofts.ui.ScreenController;
import com.ravsofts.util.ReadObject;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Dialogs;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Ravjot
 */
public class MembershipFormEditContactDetailsController implements Initializable, ControlledScreen{
    
     ScreenController myController;
    @FXML
    TextField telephoneNumber;
    @FXML
    TextField mobileNo;
    @FXML
    TextField emailAddress;
    ContactInfo contactInfoDetails = new ContactInfo();
    private Pattern pattern;
    
    private MembershipInfo membershipInfoFromFile;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Bindings.bindBidirectional(emailAddress.textProperty(), contactInfoDetails.emailAddressProperty());
        Bindings.bindBidirectional(mobileNo.textProperty(), contactInfoDetails.mobileNoProperty());
        Bindings.bindBidirectional(telephoneNumber.textProperty(), contactInfoDetails.telephoneNoProperty());
        
        ReadObject readObject = new ReadObject();
        MembershipInfo membershipInfo =  readObject.readObject();
        
        emailAddress.setText(membershipInfo.getContactInfo().getEmailAddress());
        mobileNo.setText(membershipInfo.getContactInfo().getMobileNo());
        telephoneNumber.setText(membershipInfo.getContactInfo().getTelephoneNo());
        membershipInfoFromFile = membershipInfo;
    }

    @Override
    public void setScreenParent(ScreenController screenPage) {
        myController = screenPage;
    }

    @FXML
    public void moveToAddressDetailsPage() {
        myController.setScreen(GlobalConstants.addressDetailsEditScreen);
    }

    @FXML
    public void addNomineeDetailsHandler() {
        Stage stage = new Stage();
        Group root = new Group();
        root.getChildren().addAll(myController.getNodeScreen(GlobalConstants.nomineeDetailsEditScreen));
        root.autosize();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle(GlobalConstants.subStageTitle);
        stage.getIcons().add(new Image(GlobalConstants.stageIconImageLocation));
        stage.show();
    }

    @FXML
    public void submitButtonHandler() {
        List<NomineeDetails> nominees = ((MembershipFormEditNomineesDetailsController) myController.getControlledScreen(GlobalConstants.nomineeDetailsEditScreen)).nominees;
        if(nominees == null || nominees.isEmpty()){
            nominees = membershipInfoFromFile.getNomineeDetails();
            ((MembershipFormEditNomineesDetailsController) myController.getControlledScreen(GlobalConstants.nomineeDetailsEditScreen)).nominees = nominees;
        }
        String emailId = contactInfoDetails.getEmailAddress();
        String telephoneNo = contactInfoDetails.getTelephoneNo();
        String mobileNumber = contactInfoDetails.getMobileNo();
        pattern = Pattern.compile(GlobalConstants.EMAIL_PATTERN);
        if (emailId == null || emailId.trim().length() == 0) {
            Dialogs.showErrorDialog(null, null, GlobalConstants.invalidEmailAddressFieldMessage, GlobalConstants.ERROR);
        } else if (telephoneNo == null || telephoneNo.trim().length() == 0) {
            Dialogs.showErrorDialog(null, null,GlobalConstants.invalidTelephoneFieldMessage , GlobalConstants.ERROR);
        } else if (mobileNumber == null || mobileNumber.trim().length() == 0) {
            Dialogs.showErrorDialog(null, null,GlobalConstants.invalidMobileNoFieldMessage , GlobalConstants.ERROR);
        } else if (nominees == null || nominees.isEmpty()) {
            Dialogs.showErrorDialog(null, null, GlobalConstants.noNomineesDetailsMessage, GlobalConstants.ERROR);
        } else if (!pattern.matcher(emailId).matches()) {
            Dialogs.showErrorDialog(null, null, GlobalConstants.invalidEmailIdPatterMessage, GlobalConstants.ERROR);
        } else {           
            myController.setScreen(GlobalConstants.agreementEditScreen);
        }
    }
    
}

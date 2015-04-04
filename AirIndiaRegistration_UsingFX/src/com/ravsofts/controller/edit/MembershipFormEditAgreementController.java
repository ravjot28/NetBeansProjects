/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravsofts.controller.edit;

import com.ravsofts.constants.GlobalConstants;
import com.ravsofts.controller.ControlledScreen;
import com.ravsofts.dao.AddressDetails;
import com.ravsofts.dao.AddressDetailsSerializable;
import com.ravsofts.dao.ContactDetailsSerializable;
import com.ravsofts.dao.ContactInfo;
import com.ravsofts.dao.EmployeeDetails;
import com.ravsofts.dao.EmployeeDetailsSerializable;
import com.ravsofts.dao.MembershipInfo;
import com.ravsofts.dao.NomineeDetails;
import com.ravsofts.sendreceievedata.SendEmployeeRequest;
import com.ravsofts.ui.ScreenController;
import com.ravsofts.util.SaveObject;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialogs;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Ravjot
 */
public class MembershipFormEditAgreementController implements Initializable, ControlledScreen{
     ScreenController myController;
    private Stage stage = new Stage();
    private boolean validation;
    private MembershipInfo membershipInfo;

    @FXML
    private Button iDisagree;
    
    @FXML
    private Button iAgree;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    public void setScreenParent(ScreenController screenPage) {
        myController = screenPage;
    }

    @FXML
    public void disagreeHandler() {
        Dialogs.DialogResponse response = Dialogs.showConfirmDialog(null, "Are you sure you want to quit the registration?", "Alert");
        if (response.equals(Dialogs.DialogResponse.OK)) {
            System.exit(0);
        }
    }

    @FXML
    public void agreeHandler() {
        int count = 0;
        AddressDetailsSerializable addressDetailsSerializable = new AddressDetailsSerializable();
        ContactDetailsSerializable contactDetailsSerializable = new ContactDetailsSerializable();
        EmployeeDetailsSerializable employeeDetailsSerializable = new EmployeeDetailsSerializable();
        
        SaveObject saveObject = new SaveObject();
        membershipInfo = new MembershipInfo();

        List<NomineeDetails> nominees = ((MembershipFormEditNomineesDetailsController) myController.getControlledScreen(GlobalConstants.nomineeDetailsEditScreen)).nominees;
        EmployeeDetails employeeDetails = ((MembershipFormEditEmployeeDetailsController) myController.getControlledScreen(GlobalConstants.employeeDetailsEditScreen)).employeeDetails;
        AddressDetails addressDetails = ((MembershipFormEditAddressDetailsController) myController.getControlledScreen(GlobalConstants.addressDetailsEditScreen)).addressDetails;
        ContactInfo contactInfo = ((MembershipFormEditContactDetailsController) myController.getControlledScreen(GlobalConstants.contactDetailsEditScreen)).contactInfoDetails;

        employeeDetailsSerializable.setDateOfBirth(employeeDetails.getDateOfBirth());
        employeeDetailsSerializable.setFullName(employeeDetails.getFullName());
        employeeDetailsSerializable.setStaffNo(employeeDetails.getStaffNo());
        
        contactDetailsSerializable.setEmailAddress(contactInfo.getEmailAddress());
        contactDetailsSerializable.setMobileNo(contactInfo.getMobileNo());
        contactDetailsSerializable.setTelephoneNo(contactInfo.getTelephoneNo());
        
        addressDetailsSerializable.setAddress(addressDetails.getAddress());
        addressDetailsSerializable.setCity(addressDetails.getCity());
        addressDetailsSerializable.setPinCode(addressDetails.getPinCode());
        addressDetailsSerializable.setState(addressDetails.getState());

        String fullName = employeeDetails.getFullName();
        String staffNo = employeeDetails.getStaffNo();
        Calendar dob = employeeDetails.getDateOfBirth();
        String address = addressDetails.getAddress();
        String city = addressDetails.getCity();
        String state = addressDetails.getState();
        String pinCode = addressDetails.getPinCode();
        String emailAddress = contactInfo.getEmailAddress();
        String telephoneNumber = contactInfo.getTelephoneNo();
        String mobileNumber = contactInfo.getMobileNo();

        System.out.println("Details");
        System.out.println("Full Name " + fullName);
        System.out.println("Staff No" + staffNo);
        System.out.println("Date Of Birth " + dob);
        System.out.println("Address " + address);
        System.out.println("City " + city);
        System.out.println("State " + state);
        System.out.println("Pin Code" + pinCode);
        System.out.println("Email Address " + emailAddress);
        System.out.println("Telephone Number " + telephoneNumber);
        System.out.println("Mobile Number " + mobileNumber);

        for (NomineeDetails nomineeDetails : nominees) {
            count++;
            System.out.println("Nominee " + count + " --> ");
            System.out.println("Full Name " + nomineeDetails.getFullName());
            System.out.println("Address " + nomineeDetails.getAddress());
            System.out.println("Age " + nomineeDetails.getAge());
            System.out.println("Identification Proofs " + nomineeDetails.getIdentificationProofs());
            System.out.println("Percentage " + nomineeDetails.getPercentage());
            System.out.println("Proofs " + nomineeDetails.getProofs());
            System.out.println("Related " + nomineeDetails.getRelated());
            System.out.println("Relative " + nomineeDetails.getRelative());
            System.out.println("Relative Info " + nomineeDetails.getRelativeInfo());
        }
        
        membershipInfo.setEmployeeDetails(employeeDetailsSerializable);
        membershipInfo.setContactInfo(contactDetailsSerializable);
        membershipInfo.setAddressDetails(addressDetailsSerializable);
        membershipInfo.setNomineeDetails(nominees);


        if (saveObject.saveObject(membershipInfo)) {
            Group root = new Group();
            root.getChildren().addAll(myController.getNodeScreen(GlobalConstants.sendRequestScreen));
            root.autosize();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle(GlobalConstants.sendRequestStageTitle);
            stage.getIcons().add(new Image(GlobalConstants.stageIconImageLocation));
            stage.centerOnScreen();
            stage.setFocused(true);
            iAgree.disableProperty().set(true);
            iDisagree.disableProperty().set(true);
            stage.show();

            Task task = new Task<Void>() {
                @Override
                public Void call() {
                    try {
                       String staffNo = membershipInfo.getEmployeeDetails().getStaffNo();
                        String fullName = membershipInfo.getEmployeeDetails().getFullName();
                        Calendar dob = membershipInfo.getEmployeeDetails().getDateOfBirth();

                        String address = membershipInfo.getAddressDetails().getAddress();
                        String city = membershipInfo.getAddressDetails().getCity();
                        String pinCode = membershipInfo.getAddressDetails().getPinCode();
                        String state = membershipInfo.getAddressDetails().getState();

                        String emailAddress = membershipInfo.getContactInfo().getEmailAddress();
                        String mobileNumber = membershipInfo.getContactInfo().getMobileNo();
                        String telephoneNumber = membershipInfo.getContactInfo().getTelephoneNo();

                        List<NomineeDetails> nomineeDetails = membershipInfo.getNomineeDetails();

                        String requestHeader = "E"+staffNo;
                        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
                        String requestDetail = fullName + "^" + staffNo + "^" + address + "^" + city + "^" + state + "^"
                                + pinCode + "^" + telephoneNumber + "^" + mobileNumber + "^" + emailAddress + "^"
                                + format1.format(dob.getTime()).replace("/0", "/") + "^";

                        String nomineeDetail = "";

                        for (NomineeDetails nd : nomineeDetails) {
                            String relative = null;
                            if (nd.getRelativeInfo().equalsIgnoreCase("w/o")) {
                                relative = "W/o";
                            } else if (nd.getRelativeInfo().equalsIgnoreCase("s/o")) {
                                relative = "S/o";
                            } else if (nd.getRelativeInfo().equalsIgnoreCase("d/o")) {
                                relative = "D/o";
                            }
                            nomineeDetail += nd.getFullName() + "||" + relative + "||"
                                    + nd.getRelative() + "||" + nd.getAge() + "||" + nd.getProofs() + "||"
                                    + nd.getIdentificationProofs() + "||" + nd.getRelated() + "||" + nd.getPercentage()
                                    + "||" + nd.getAddress() + "^";
                        }


                        String requestedDetails = requestDetail + "$$$" + nomineeDetail;

                        SendEmployeeRequest ser = new SendEmployeeRequest(requestHeader, requestedDetails);
                        if (ser.process()) {
                                validation = true;
                        } else {
                            internetConnectionError();
                        }

                        if (validation) {
                            passedValidation();
                        } else {
                            internetConnectionError();
                        }

                    } catch (Exception ex) {
                        internetConnectionError();
                    }
                    return null;
                }
            };
            new Thread(task).start();
        } else {
            Dialogs.showErrorDialog(null, null, GlobalConstants.accessErrorMessage, GlobalConstants.ERROR);
        }
    }
    
    public void passedValidation() {
        Platform.runLater(new Runnable() {
            public void run() {
                Dialogs.showInformationDialog(null, null, GlobalConstants.registerationComplete, GlobalConstants.success);
                iAgree.disableProperty().set(true);
                iDisagree.disableProperty().set(true);
                stage.hide();
            }
        });
    }

    public void internetConnectionError() {
        Platform.runLater(new Runnable() {
            public void run() {
                iAgree.disableProperty().set(false);
                iDisagree.disableProperty().set(false);
                stage.hide();
                Dialogs.showErrorDialog(null, null, GlobalConstants.internetConnectionErrorMessage, GlobalConstants.ERROR);
            }
        });
    }
}

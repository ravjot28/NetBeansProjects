/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravsofts.controller;

import com.ravsofts.constants.GlobalConstants;
import com.ravsofts.dao.AddressDetails;
import com.ravsofts.dao.Nominee1Details;
import com.ravsofts.dao.Nominee2Details;
import com.ravsofts.dao.Nominee3Details;
import com.ravsofts.dao.Nominee4Details;
import com.ravsofts.dao.NomineeDetails;
import com.ravsofts.ui.ScreenController;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialogs;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Ravjot
 */
public class MembershipFormNomineesDetailsController implements Initializable, ControlledScreen {

    ScreenController myController;
    @FXML
    private AnchorPane nomineePane;
    @FXML
    private TextField nominee1FullName;
    @FXML
    private ChoiceBox nominee1RelativeInfo;
    @FXML
    private TextField nominee1Age;
    @FXML
    private TextField nominee1Relative;
    @FXML
    private ChoiceBox nominee1Proofs;
    @FXML
    private TextField nominee1IdentificationProof;
    @FXML
    private TextField nominee1Related;
    @FXML
    private TextField nominee1Percentage;
    @FXML
    private TextArea nominee1Address;
    @FXML
    private TextField nominee2FullName;
    @FXML
    private ChoiceBox nominee2RelativeInfo;
    @FXML
    private TextField nominee2Age;
    @FXML
    private TextField nominee2Relative;
    @FXML
    private ChoiceBox nominee2Proofs;
    @FXML
    private TextField nominee2IdentificationProof;
    @FXML
    private TextField nominee2Related;
    @FXML
    private TextField nominee2Percentage;
    @FXML
    private TextArea nominee2Address;
    @FXML
    private TextField nominee3FullName;
    @FXML
    private ChoiceBox nominee3RelativeInfo;
    @FXML
    private TextField nominee3Age;
    @FXML
    private TextField nominee3Relative;
    @FXML
    private ChoiceBox nominee3Proofs;
    @FXML
    private TextField nominee3IdentificationProof;
    @FXML
    private TextField nominee3Related;
    @FXML
    private TextField nominee3Percentage;
    @FXML
    private TextArea nominee3Address;
    @FXML
    private TextField nominee4FullName;
    @FXML
    private ChoiceBox nominee4RelativeInfo;
    @FXML
    private TextField nominee4Age;
    @FXML
    private TextField nominee4Relative;
    @FXML
    private ChoiceBox nominee4Proofs;
    @FXML
    private TextField nominee4IdentificationProof;
    @FXML
    private TextField nominee4Related;
    @FXML
    private TextField nominee4Percentage;
    @FXML
    private TextArea nominee4Address;
    public Nominee1Details nominee1Details = new Nominee1Details();
    public Nominee2Details nominee2Details = new Nominee2Details();
    public Nominee3Details nominee3Details = new Nominee3Details();
    public Nominee4Details nominee4Details = new Nominee4Details();
    public int noOfNomineesSelected = 0;
    public int sumOfPercentage = 0;
    
    public List<NomineeDetails> nominees;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Bindings.bindBidirectional(nominee1FullName.textProperty(), nominee1Details.fullNameProperty());
        Bindings.bindBidirectional(nominee1Age.textProperty(), nominee1Details.ageProperty());
        Bindings.bindBidirectional(nominee1Relative.textProperty(), nominee1Details.relativeProperty());
        Bindings.bindBidirectional(nominee1IdentificationProof.textProperty(), nominee1Details.identificationProofsProperty());
        Bindings.bindBidirectional(nominee1Related.textProperty(), nominee1Details.relatedProperty());
        Bindings.bindBidirectional(nominee1Percentage.textProperty(), nominee1Details.percentageProperty());
        Bindings.bindBidirectional(nominee1Address.textProperty(), nominee1Details.addressProperty());

        Bindings.bindBidirectional(nominee2FullName.textProperty(), nominee2Details.fullNameProperty());
        Bindings.bindBidirectional(nominee2Age.textProperty(), nominee2Details.ageProperty());
        Bindings.bindBidirectional(nominee2Relative.textProperty(), nominee2Details.relativeProperty());
        Bindings.bindBidirectional(nominee2IdentificationProof.textProperty(), nominee2Details.identificationProofsProperty());
        Bindings.bindBidirectional(nominee2Related.textProperty(), nominee2Details.relatedProperty());
        Bindings.bindBidirectional(nominee2Percentage.textProperty(), nominee2Details.percentageProperty());
        Bindings.bindBidirectional(nominee2Address.textProperty(), nominee2Details.addressProperty());

        Bindings.bindBidirectional(nominee3FullName.textProperty(), nominee3Details.fullNameProperty());
        Bindings.bindBidirectional(nominee3Age.textProperty(), nominee3Details.ageProperty());
        Bindings.bindBidirectional(nominee3Relative.textProperty(), nominee3Details.relativeProperty());
        Bindings.bindBidirectional(nominee3IdentificationProof.textProperty(), nominee3Details.identificationProofsProperty());
        Bindings.bindBidirectional(nominee3Related.textProperty(), nominee3Details.relatedProperty());
        Bindings.bindBidirectional(nominee3Percentage.textProperty(), nominee3Details.percentageProperty());
        Bindings.bindBidirectional(nominee3Address.textProperty(), nominee3Details.addressProperty());

        Bindings.bindBidirectional(nominee4FullName.textProperty(), nominee4Details.fullNameProperty());
        Bindings.bindBidirectional(nominee4Age.textProperty(), nominee4Details.ageProperty());
        Bindings.bindBidirectional(nominee4Relative.textProperty(), nominee4Details.relativeProperty());
        Bindings.bindBidirectional(nominee4IdentificationProof.textProperty(), nominee4Details.identificationProofsProperty());
        Bindings.bindBidirectional(nominee4Related.textProperty(), nominee4Details.relatedProperty());
        Bindings.bindBidirectional(nominee4Percentage.textProperty(), nominee4Details.percentageProperty());
        Bindings.bindBidirectional(nominee4Address.textProperty(), nominee4Details.addressProperty());

        nominee1RelativeInfo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> selected, String oldValue, String newVlaue) {
                if (newVlaue != null) {
                    nominee1Details.setRelativeInfo(newVlaue);
                }
            }
        });
        nominee1Proofs.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> selected, String oldValue, String newVlaue) {
                if (newVlaue != null) {
                    nominee1Details.setProofs(newVlaue);
                }
            }
        });

        nominee2RelativeInfo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> selected, String oldValue, String newVlaue) {
                if (newVlaue != null) {
                    nominee2Details.setRelativeInfo(newVlaue);
                }
            }
        });
        nominee2Proofs.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> selected, String oldValue, String newVlaue) {
                if (newVlaue != null) {
                    nominee2Details.setProofs(newVlaue);
                }
            }
        });

        nominee3RelativeInfo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> selected, String oldValue, String newVlaue) {
                if (newVlaue != null) {
                    nominee3Details.setRelativeInfo(newVlaue);
                }
            }
        });
        nominee3Proofs.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> selected, String oldValue, String newVlaue) {
                if (newVlaue != null) {
                    nominee3Details.setProofs(newVlaue);
                }
            }
        });

        nominee4RelativeInfo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> selected, String oldValue, String newVlaue) {
                if (newVlaue != null) {
                    nominee4Details.setRelativeInfo(newVlaue);
                }

            }
        });
        nominee4Proofs.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> selected, String oldValue, String newVlaue) {
                if (newVlaue != null) {
                    nominee4Details.setProofs(newVlaue);
                }
            }
        });
    }

    @Override
    public void setScreenParent(ScreenController screenPage) {
        myController = screenPage;
    }

    @FXML
    public void saveButtonHandle() {
        int passed = 0;
        sumOfPercentage = 0;
        noOfNomineesSelected = 0;
        nominees = new ArrayList();
        NomineeDetails nomineeDetails;
        String nominee1FullNameField = nominee1Details.getFullName();
        String nominee1AddressField = nominee1Details.getAddress();
        String nominee1AgeField = nominee1Details.getAge();
        String nominee1IdentificationProofs = nominee1Details.getIdentificationProofs();
        String nominee1PercentageField = nominee1Details.getPercentage();
        String nominee1ProofsField = nominee1Details.getProofs();
        String nominee1RelatedField = nominee1Details.getRelated();
        String nominee1RelativeField = nominee1Details.getRelative();
        String nominee1RelativeInfoField = nominee1Details.getRelativeInfo();

        String nominee2FullNameField = nominee2Details.getFullName();
        String nominee2AddressField = nominee2Details.getAddress();
        String nominee2AgeField = nominee2Details.getAge();
        String nominee2IdentificationProofs = nominee2Details.getIdentificationProofs();
        String nominee2PercentageField = nominee2Details.getPercentage();
        String nominee2ProofsField = nominee2Details.getProofs();
        String nominee2RelatedField = nominee2Details.getRelated();
        String nominee2RelativeField = nominee2Details.getRelative();
        String nominee2RelativeInfoField = nominee2Details.getRelativeInfo();

        String nominee3FullNameField = nominee3Details.getFullName();
        String nominee3AddressField = nominee3Details.getAddress();
        String nominee3AgeField = nominee3Details.getAge();
        String nominee3IdentificationProofs = nominee3Details.getIdentificationProofs();
        String nominee3PercentageField = nominee3Details.getPercentage();
        String nominee3ProofsField = nominee3Details.getProofs();
        String nominee3RelatedField = nominee3Details.getRelated();
        String nominee3RelativeField = nominee3Details.getRelative();
        String nominee3RelativeInfoField = nominee3Details.getRelativeInfo();

        String nominee4FullNameField = nominee4Details.getFullName();
        String nominee4AddressField = nominee4Details.getAddress();
        String nominee4AgeField = nominee4Details.getAge();
        String nominee4IdentificationProofs = nominee4Details.getIdentificationProofs();
        String nominee4PercentageField = nominee4Details.getPercentage();
        String nominee4ProofsField = nominee4Details.getProofs();
        String nominee4RelatedField = nominee4Details.getRelated();
        String nominee4RelativeField = nominee4Details.getRelative();
        String nominee4RelativeInfoField = nominee4Details.getRelativeInfo();

        if ((nominee1FullNameField != null && nominee1FullNameField.trim().length() > 0)
                || (nominee1AddressField != null && nominee1AddressField.trim().length() > 0)
                || (nominee1AgeField != null && nominee1AgeField.trim().length() > 0)
                || (nominee1IdentificationProofs != null && nominee1IdentificationProofs.trim().length() > 0)
                || (nominee1PercentageField != null && nominee1PercentageField.trim().length() > 0)
                || (nominee1ProofsField != null && nominee1ProofsField.trim().length() > 0)
                || (nominee1RelatedField != null && nominee1RelatedField.trim().length() > 0)
                || (nominee1RelativeField != null && nominee1RelativeField.trim().length() > 0)
                || (nominee1RelativeInfoField != null && nominee1RelativeInfoField.trim().length() > 0)) {

            if (nominee1FullNameField == null || nominee1FullNameField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidFullNameNominee1Message, GlobalConstants.ERROR);
            } else if (nominee1AddressField == null || nominee1AddressField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidAddressNominee1Message, GlobalConstants.ERROR);
            } else if (nominee1AgeField == null || nominee1AgeField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidAgeNominee1Message, GlobalConstants.ERROR);
            } else if (nominee1IdentificationProofs == null || nominee1IdentificationProofs.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidIdentificationProofNominee1Message, GlobalConstants.ERROR);
            } else if (nominee1PercentageField == null || nominee1PercentageField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.emptyPercentageNominee1Message, GlobalConstants.ERROR);
            } else if (nominee1ProofsField == null || nominee1ProofsField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidProofNominee1Message, GlobalConstants.ERROR);
            } else if (nominee1RelatedField == null || nominee1RelatedField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidRelatedNominee1Message, GlobalConstants.ERROR);
            } else if (nominee1RelativeField == null || nominee1RelativeField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null,GlobalConstants.invalidRelativeNominee1Message, GlobalConstants.ERROR);
            } else if (nominee1RelativeInfoField == null || nominee1RelativeInfoField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidRelativeIndormationNominee1Message, GlobalConstants.ERROR);
            } else {
                try {
                    sumOfPercentage += Integer.parseInt(nominee1PercentageField.replace(GlobalConstants.percentageSymbol, GlobalConstants.emptyString).trim());
                    noOfNomineesSelected++;
                    nomineeDetails = new NomineeDetails();
                    nomineeDetails.setAddress(nominee1AddressField);
                    nomineeDetails.setAge(nominee1AgeField);
                    nomineeDetails.setFullName(nominee1FullNameField);
                    nomineeDetails.setIdentificationProofs(nominee1IdentificationProofs);
                    nomineeDetails.setPercentage(nominee1PercentageField);
                    nomineeDetails.setProofs(nominee1ProofsField);
                    nomineeDetails.setRelated(nominee1RelatedField);
                    nomineeDetails.setRelative(nominee1RelativeField);
                    nomineeDetails.setRelativeInfo(nominee1RelativeInfoField);
                    nominees.add(nomineeDetails);
                } catch (Exception e) {
                    passed = -1;
                    Dialogs.showErrorDialog(null, null, GlobalConstants.invalidPercentageNominee1Message, GlobalConstants.ERROR);
                }
            }

        }

        if ((nominee2FullNameField != null && nominee2FullNameField.trim().length() > 0)
                || (nominee2AddressField != null && nominee2AddressField.trim().length() > 0)
                || (nominee2AgeField != null && nominee2AgeField.trim().length() > 0)
                || (nominee2IdentificationProofs != null && nominee2IdentificationProofs.trim().length() > 0)
                || (nominee2PercentageField != null && nominee2PercentageField.trim().length() > 0)
                || (nominee2ProofsField != null && nominee2ProofsField.trim().length() > 0)
                || (nominee2RelatedField != null && nominee2RelatedField.trim().length() > 0)
                || (nominee2RelativeField != null && nominee2RelativeField.trim().length() > 0)
                || (nominee2RelativeInfoField != null && nominee2RelativeInfoField.trim().length() > 0)) {

            if (nominee2FullNameField == null || nominee2FullNameField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidFullNameNominee2Message, GlobalConstants.ERROR);
            } else if (nominee2AddressField == null || nominee2AddressField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidAddressNominee2Message, GlobalConstants.ERROR);
            } else if (nominee2AgeField == null || nominee2AgeField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidAgeNominee2Message, GlobalConstants.ERROR);
            } else if (nominee2IdentificationProofs == null || nominee2IdentificationProofs.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidIdentificationProofNominee2Message, GlobalConstants.ERROR);
            } else if (nominee2PercentageField == null || nominee2PercentageField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.emptyPercentageNominee2Message, GlobalConstants.ERROR);
            } else if (nominee2ProofsField == null || nominee2ProofsField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidProofNominee2Message, GlobalConstants.ERROR);
            } else if (nominee2RelatedField == null || nominee2RelatedField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidRelatedNominee2Message, GlobalConstants.ERROR);
            } else if (nominee2RelativeField == null || nominee2RelativeField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidRelativeNominee2Message, GlobalConstants.ERROR);
            } else if (nominee2RelativeInfoField == null || nominee2RelativeInfoField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidRelativeIndormationNominee2Message, GlobalConstants.ERROR);
            } else {
                try {
                    sumOfPercentage += Integer.parseInt(nominee2PercentageField.replace(GlobalConstants.percentageSymbol, GlobalConstants.emptyString).trim());
                    noOfNomineesSelected++;
                    nomineeDetails = new NomineeDetails();
                    nomineeDetails.setAddress(nominee2AddressField);
                    nomineeDetails.setAge(nominee2AgeField);
                    nomineeDetails.setFullName(nominee2FullNameField);
                    nomineeDetails.setIdentificationProofs(nominee2IdentificationProofs);
                    nomineeDetails.setPercentage(nominee2PercentageField);
                    nomineeDetails.setProofs(nominee2ProofsField);
                    nomineeDetails.setRelated(nominee2RelatedField);
                    nomineeDetails.setRelative(nominee2RelativeField);
                    nomineeDetails.setRelativeInfo(nominee2RelativeInfoField);
                    nominees.add(nomineeDetails);
                } catch (Exception e) {
                    passed = -1;
                    Dialogs.showErrorDialog(null, null, GlobalConstants.invalidPercentageNominee2Message, GlobalConstants.ERROR);
                }
            }
        }

        if ((nominee3FullNameField != null && nominee3FullNameField.trim().length() > 0)
                || (nominee3AddressField != null && nominee3AddressField.trim().length() > 0)
                || (nominee3AgeField != null && nominee3AgeField.trim().length() > 0)
                || (nominee3IdentificationProofs != null && nominee3IdentificationProofs.trim().length() > 0)
                || (nominee3PercentageField != null && nominee3PercentageField.trim().length() > 0)
                || (nominee3ProofsField != null && nominee3ProofsField.trim().length() > 0)
                || (nominee3RelatedField != null && nominee3RelatedField.trim().length() > 0)
                || (nominee3RelativeField != null && nominee3RelativeField.trim().length() > 0)
                || (nominee3RelativeInfoField != null && nominee3RelativeInfoField.trim().length() > 0)) {

            if (nominee3FullNameField == null || nominee3FullNameField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidFullNameNominee3Message, GlobalConstants.ERROR);
            } else if (nominee3AddressField == null || nominee3AddressField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidAddressNominee3Message, GlobalConstants.ERROR);
            } else if (nominee3AgeField == null || nominee3AgeField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidAgeNominee3Message, GlobalConstants.ERROR);
            } else if (nominee3IdentificationProofs == null || nominee3IdentificationProofs.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidIdentificationProofNominee3Message, GlobalConstants.ERROR);
            } else if (nominee3PercentageField == null || nominee3PercentageField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.emptyPercentageNominee3Message, GlobalConstants.ERROR);
            } else if (nominee3ProofsField == null || nominee3ProofsField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidProofNominee3Message, GlobalConstants.ERROR);
            } else if (nominee3RelatedField == null || nominee3RelatedField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidRelatedNominee3Message, GlobalConstants.ERROR);
            } else if (nominee3RelativeField == null || nominee3RelativeField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidRelativeNominee3Message, GlobalConstants.ERROR);
            } else if (nominee3RelativeInfoField == null || nominee3RelativeInfoField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidRelativeIndormationNominee3Message, GlobalConstants.ERROR);
            } else {
                try {
                    sumOfPercentage += Integer.parseInt(nominee3PercentageField.replace(GlobalConstants.percentageSymbol, GlobalConstants.emptyString).trim());
                    noOfNomineesSelected++;
                    nomineeDetails = new NomineeDetails();
                    nomineeDetails.setAddress(nominee3AddressField);
                    nomineeDetails.setAge(nominee3AgeField);
                    nomineeDetails.setFullName(nominee3FullNameField);
                    nomineeDetails.setIdentificationProofs(nominee3IdentificationProofs);
                    nomineeDetails.setPercentage(nominee3PercentageField);
                    nomineeDetails.setProofs(nominee3ProofsField);
                    nomineeDetails.setRelated(nominee3RelatedField);
                    nomineeDetails.setRelative(nominee3RelativeField);
                    nomineeDetails.setRelativeInfo(nominee3RelativeInfoField);
                    nominees.add(nomineeDetails);
                } catch (Exception e) {
                    passed = -1;
                    Dialogs.showErrorDialog(null, null, GlobalConstants.invalidPercentageNominee3Message, GlobalConstants.ERROR);
                }
            }
        }

        if ((nominee4FullNameField != null && nominee4FullNameField.trim().length() > 0)
                || (nominee4AddressField != null && nominee4AddressField.trim().length() > 0)
                || (nominee4AgeField != null && nominee4AgeField.trim().length() > 0)
                || (nominee4IdentificationProofs != null && nominee4IdentificationProofs.trim().length() > 0)
                || (nominee4PercentageField != null && nominee4PercentageField.trim().length() > 0)
                || (nominee4ProofsField != null && nominee4ProofsField.trim().length() > 0)
                || (nominee4RelatedField != null && nominee4RelatedField.trim().length() > 0)
                || (nominee4RelativeField != null && nominee4RelativeField.trim().length() > 0)
                || (nominee4RelativeInfoField != null && nominee4RelativeInfoField.trim().length() > 0)) {

            if (nominee4FullNameField == null || nominee4FullNameField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidFullNameNominee4Message, GlobalConstants.ERROR);
            } else if (nominee4AddressField == null || nominee4AddressField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidAddressNominee4Message, GlobalConstants.ERROR);
            } else if (nominee4AgeField == null || nominee4AgeField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidAgeNominee4Message, GlobalConstants.ERROR);
            } else if (nominee4IdentificationProofs == null || nominee4IdentificationProofs.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidIdentificationProofNominee4Message, GlobalConstants.ERROR);
            } else if (nominee4PercentageField == null || nominee4PercentageField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.emptyPercentageNominee4Message, GlobalConstants.ERROR);
            } else if (nominee4ProofsField == null || nominee4ProofsField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidProofNominee4Message, GlobalConstants.ERROR);
            } else if (nominee4RelatedField == null || nominee4RelatedField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidRelatedNominee4Message, GlobalConstants.ERROR);
            } else if (nominee4RelativeField == null || nominee4RelativeField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidRelativeNominee4Message, GlobalConstants.ERROR);
            } else if (nominee4RelativeInfoField == null || nominee4RelativeInfoField.trim().length() == 0) {
                passed = -1;
                Dialogs.showErrorDialog(null, null, GlobalConstants.invalidRelativeIndormationNominee4Message, GlobalConstants.ERROR);
            } else {
                try {
                    sumOfPercentage += Integer.parseInt(nominee4PercentageField.replace(GlobalConstants.percentageSymbol, GlobalConstants.emptyString).trim());
                    noOfNomineesSelected++;
                    nomineeDetails = new NomineeDetails();
                    nomineeDetails.setAddress(nominee4AddressField);
                    nomineeDetails.setAge(nominee4AgeField);
                    nomineeDetails.setFullName(nominee4FullNameField);
                    nomineeDetails.setIdentificationProofs(nominee4IdentificationProofs);
                    nomineeDetails.setPercentage(nominee4PercentageField);
                    nomineeDetails.setProofs(nominee4ProofsField);
                    nomineeDetails.setRelated(nominee4RelatedField);
                    nomineeDetails.setRelative(nominee4RelativeField);
                    nomineeDetails.setRelativeInfo(nominee4RelativeInfoField);
                    nominees.add(nomineeDetails);
                } catch (Exception e) {
                    passed = -1;
                    Dialogs.showErrorDialog(null, null, GlobalConstants.invalidPercentageNominee4Message, GlobalConstants.ERROR);
                }
            }
        }

        if (noOfNomineesSelected > 0 && passed == 0) {
            if (sumOfPercentage >=100) {
                
                Scene scene = nomineePane.getScene();
                if (scene != null) {
                    Window window = scene.getWindow();
                    if (window != null) {
                        window.hide();
                    }
                }
            } else {
                Dialogs.showErrorDialog(null, null,GlobalConstants.invalidPercentageEnteredMessage , GlobalConstants.ERROR);
                noOfNomineesSelected = 0;
            }
        }
    }
    
    @FXML
    public void copyAddressNominee1(){
        AddressDetails addressDetails = ((MembershipFormAddressDetailsController) myController.getControlledScreen(GlobalConstants.addressDetailsScreen)).addressDetails;
        nominee1Address.setText(addressDetails.getAddress()+"\n"+addressDetails.getCity()+"\n"+addressDetails.getState()+"\n"+addressDetails.getPinCode());
        
    } 
    
    @FXML
    public void copyAddressNominee2(){
        AddressDetails addressDetails = ((MembershipFormAddressDetailsController) myController.getControlledScreen(GlobalConstants.addressDetailsScreen)).addressDetails;
        nominee2Address.setText(addressDetails.getAddress()+"\n"+addressDetails.getCity()+"\n"+addressDetails.getState()+"\n"+addressDetails.getPinCode());
    } 
    
    @FXML
    public void copyAddressNominee3(){
        AddressDetails addressDetails = ((MembershipFormAddressDetailsController) myController.getControlledScreen(GlobalConstants.addressDetailsScreen)).addressDetails;
        nominee3Address.setText(addressDetails.getAddress()+"\n"+addressDetails.getCity()+"\n"+addressDetails.getState()+"\n"+addressDetails.getPinCode());
    } 
    
    @FXML
    public void copyAddressNominee4(){
        AddressDetails addressDetails = ((MembershipFormAddressDetailsController) myController.getControlledScreen(GlobalConstants.addressDetailsScreen)).addressDetails;
        nominee4Address.setText(addressDetails.getAddress()+"\n"+addressDetails.getCity()+"\n"+addressDetails.getState()+"\n"+addressDetails.getPinCode());
    } 
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravsofts.constants;

/**
 *
 * @author Ravjot
 */
public class GlobalConstants {

    public static final String folderName = "RavSoftsData";
    public static final String fileExtension = ".ravs";
    public static final String userHome = "user.home";
    public static final String fileName = "membershipDetails"+fileExtension;
    public static final String fileSeparator = "file.separator";
    public static final String employeeDetailsScreen = "employeeDetails";
    public static final String addressDetailsScreen = "addressDetails";
    public static final String contactDetailsScreen = "contactDetails";
    public static final String nomineeDetailsScreen = "nomineeDetails";
    public static final String agreementScreen = "agreement";
    public static final String checkingStaffNoScreen = "checkingStaffNo";
    public static final String addressDetailsScreenFXML = "MembershipFormAddressDetails.fxml";
    public static final String contactDetailsScreenFXML = "MembershipFormContactDetails.fxml";
    public static final String employeeDetailsScreenFXML = "MembershipFormEmployeeDetails.fxml";
    public static final String nomineeDetailsScreenFXML = "MembershipFormNomineesDetails.fxml";
    public static final String agreementScreenFXML = "MembershipFormAgreement.fxml";
    public static final String checkingStaffNoScreenFXML = "CheckingStaffNo.fxml";
    public static final String employeeDetailsEditScreen = "employeeDetailsEdit";
    public static final String addressDetailsEditScreen = "addressDetailsEdit";
    public static final String contactDetailsEditScreen = "contactDetailsEdit";
    public static final String nomineeDetailsEditScreen = "nomineeDetailsEdit";
    public static final String agreementEditScreen = "agreementEdit";
    public static final String sendRequestScreen = "sendRequest";
    public static final String addressDetailsEditScreenFXML = "MembershipFormEditAddressDetails.fxml";
    public static final String contactDetailsEditScreenFXML = "MembershipFormEditContactDetails.fxml";
    public static final String employeeDetailsEditScreenFXML = "MembershipFormEditEmployeeDetails.fxml";
    public static final String nomineeDetailsEditScreenFXML = "MembershipFormEditNomineesDetails.fxml";
    public static final String agreementEditScreenFXML = "MembershipFormEditAgreement.fxml";
    public static final String sendRequestScreenFXML = "SendRequest.fxml";
    public static final String stageIconImageLocation = "com/ravsofts/img/rav.gif";
    public static final String ERROR = "Error";
    
    //MembershipFormAddressDetailsController Constants
    public static final String invalidAddressFieldMessage = "Oops, please enter the address!";
    public static final String invalidCityFieldMessage = "Oops, please enter the city!";
    public static final String invalidPinCodeFieldMessage = "Oops, please enter the pin code!";
    public static final String invalidStateFieldMessage = "Oops, please enter the state!";
    
    //MembershipFormAgreementController Constants
    public static final String accessErrorMessage = "Oops, unable to access the system directory to save the details!";
    public static final String sendRequestStageTitle = "Sending Request...";
    
    //MembershipFormContactDetailsController Constants
    public static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String invalidEmailAddressFieldMessage = "Oops, please enter the email Address!";
    public static final String subStageTitle = "BSAEIA Nominees Details";
    public static final String invalidTelephoneFieldMessage = "Oops, please enter the telephone Number!";
    public static final String invalidMobileNoFieldMessage = "Oops, please enter the mobile number!";
    public static final String noNomineesDetailsMessage = "Oops, please enter the Nominees Details!";
    public static final String invalidEmailIdPatterMessage = "Oops, please enter valid Email Address!";
    
    //MembershipFormEmployeeDetailsController Constants
    public static final String dateOfBirthPromptText = "Date Of Birth";
    public static final String todayLabel = "Today";
    public static final String internetConnectionErrorMessage = "Oops, can not connect to the Internet. Please check the connection!";
    public static final String staffNoValidationErrorMessage = "Oops, the entered Staff Number is already registered!";
    public static final String validationStageTitle = "BSAEIA Validating Staff No.";
    public static final String invalidStaffNoFieldMessage = "Oops, please enter the Staff Number!";
    public static final String invalidDOBFieldMessage = "Oops, please enter valid Date Of Birth!";
    public static final String invalidFullNameFieldMessage = "Oops, please enter the full name!";
    
    //MembershipFormNomineesDetailsController Constants
    public static final String invalidPercentageEnteredMessage = "Oops, Sum of all percentages provided is not greater than or equal to 100% please revisit the entries";
    public static final String percentageSymbol = "%";
    public static final String emptyString = "";
    //Nominee 1
    public static final String invalidPercentageNominee1Message = "Oops, please enter Nominee 1's valid percentage!";
    public static final String invalidFullNameNominee1Message = "Oops, please enter Nominee 1's Full Name!";
    public static final String invalidAddressNominee1Message = "Oops, please enter Nominee 1's Address!";
    public static final String invalidAgeNominee1Message = "Oops, please enter Nominee 1's Age!";
    public static final String invalidIdentificationProofNominee1Message = "Oops, please enter Nominee 1's Identification Proof!";
    public static final String emptyPercentageNominee1Message = "Oops, please enter Nominee 1's Percentage!";
    public static final String invalidProofNominee1Message = "Oops, please enter Nominee 1's Proofs!";
    public static final String invalidRelatedNominee1Message = "Oops, please enter Nominee 1's Related!";
    public static final String invalidRelativeNominee1Message = "Oops, please enter Nominee 1's Relative!";
    public static final String invalidRelativeIndormationNominee1Message = "Oops, please enter Nominee 1's Relative Information!";
    //Nominee 2
    public static final String invalidPercentageNominee2Message = "Oops, please enter Nominee 2's valid percentage!";
    public static final String invalidFullNameNominee2Message = "Oops, please enter Nominee 2's Full Name!";
    public static final String invalidAddressNominee2Message = "Oops, please enter Nominee 2's Address!";
    public static final String invalidAgeNominee2Message = "Oops, please enter Nominee 2's Age!";
    public static final String invalidIdentificationProofNominee2Message = "Oops, please enter Nominee 2's Identification Proof!";
    public static final String emptyPercentageNominee2Message = "Oops, please enter Nominee 2's Percentage!";
    public static final String invalidProofNominee2Message = "Oops, please enter Nominee 2's Proofs!";
    public static final String invalidRelatedNominee2Message = "Oops, please enter Nominee 2's Related!";
    public static final String invalidRelativeNominee2Message = "Oops, please enter Nominee 2's Relative!";
    public static final String invalidRelativeIndormationNominee2Message = "Oops, please enter Nominee 2's Relative Information!";
    //Nominee 3
    public static final String invalidPercentageNominee3Message = "Oops, please enter Nominee 3's valid percentage!";
    public static final String invalidFullNameNominee3Message = "Oops, please enter Nominee 3's Full Name!";
    public static final String invalidAddressNominee3Message = "Oops, please enter Nominee 3's Address!";
    public static final String invalidAgeNominee3Message = "Oops, please enter Nominee 3's Age!";
    public static final String invalidIdentificationProofNominee3Message = "Oops, please enter Nominee 3's Identification Proof!";
    public static final String emptyPercentageNominee3Message = "Oops, please enter Nominee 3's Percentage!";
    public static final String invalidProofNominee3Message = "Oops, please enter Nominee 3's Proofs!";
    public static final String invalidRelatedNominee3Message = "Oops, please enter Nominee 3's Related!";
    public static final String invalidRelativeNominee3Message = "Oops, please enter Nominee 3's Relative!";
    public static final String invalidRelativeIndormationNominee3Message = "Oops, please enter Nominee 3's Relative Information!";
    //Nominee 4
    public static final String invalidPercentageNominee4Message = "Oops, please enter Nominee 4's valid percentage!";
    public static final String invalidFullNameNominee4Message = "Oops, please enter Nominee 4's Full Name!";
    public static final String invalidAddressNominee4Message = "Oops, please enter Nominee 4's Address!";
    public static final String invalidAgeNominee4Message = "Oops, please enter Nominee 4's Age!";
    public static final String invalidIdentificationProofNominee4Message = "Oops, please enter Nominee 4's Identification Proof!";
    public static final String emptyPercentageNominee4Message = "Oops, please enter Nominee 4's Percentage!";
    public static final String invalidProofNominee4Message = "Oops, please enter Nominee 4's Proofs!";
    public static final String invalidRelatedNominee4Message = "Oops, please enter Nominee 4's Related!";
    public static final String invalidRelativeNominee4Message = "Oops, please enter Nominee 4's Relative!";
    public static final String invalidRelativeIndormationNominee4Message = "Oops, please enter Nominee 4's Relative Information!";
    
    //ValidateStaffNo Constants
    public static final String commaSymbol = ",";
    
    //Main Constants
    public static final String calendarCSSPath = "com/ravsofts/calendar/calendarstyle.css";
    public static final String mainStageTitle = "BSAEIA Membership Form";
    public static final String editStageTitle = "BSAEIA Membership Form [Edit Mode]";
    
    
    public static final String registerationComplete = "Your request is sent successfully. Your request will be reviewed by BSAEIA admins shortly.";
    public static final String success = "SUCCESS";
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravsofts.util;

import com.ravsofts.constants.GlobalConstants;
import com.ravsofts.dao.AddressDetailsSerializable;
import com.ravsofts.dao.ContactDetailsSerializable;
import com.ravsofts.dao.EmployeeDetailsSerializable;
import com.ravsofts.dao.MembershipInfo;
import com.ravsofts.dao.NomineeDetails;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Ravjot
 */
public class ReadObject {
    
    public MembershipInfo readObject() {
        MembershipInfo e = null;
        try {
            String dir = System.getProperty(GlobalConstants.userHome) + System.getProperty(GlobalConstants.fileSeparator) + GlobalConstants.folderName;
            String serializableFileName = dir + System.getProperty(GlobalConstants.fileSeparator) + GlobalConstants.fileName;
            if (new File(serializableFileName).exists()) {
                FileInputStream fileIn =
                        new FileInputStream(serializableFileName);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                e = (MembershipInfo) in.readObject();
                in.close();
                fileIn.close();
            } else {
                String files[] = new File(dir).list();
                if (new File(files[0]).isFile()) {
                    BufferedReader b = new BufferedReader(new FileReader(dir + System.getProperty(GlobalConstants.fileSeparator) + files[0]));
                    String data = b.readLine();
                    b.close();
                    
                    e = new MembershipInfo();
                    
                    AddressDetailsSerializable addressDetailsSerializable = new AddressDetailsSerializable();
                    ContactDetailsSerializable contactDetailsSerializable = new ContactDetailsSerializable();
                    EmployeeDetailsSerializable employeeDetailsSerializable = new EmployeeDetailsSerializable();
                    List<NomineeDetails> nomineeDetails = new ArrayList();
                    
                    StringTokenizer s1 = new StringTokenizer(data, "$$$");
                    String info = s1.nextToken();
                    String nomi = s1.nextToken();
                    
                    StringTokenizer s2 = new StringTokenizer(info, "^");
                    int i = 0;
                    while (s2.hasMoreTokens()) {
                        String value = s2.nextToken();
                        switch (i) {
                            case 0:
                                employeeDetailsSerializable.setFullName(value);
                                break;
                            case 1:
                                employeeDetailsSerializable.setStaffNo(value);
                                break;
                            case 2:
                                addressDetailsSerializable.setAddress(value);
                                break;
                            case 3:
                                addressDetailsSerializable.setCity(value);
                                break;
                            case 4:
                                addressDetailsSerializable.setState(value);
                                break;
                            case 5:
                                addressDetailsSerializable.setPinCode(value);
                                break;
                            case 6:
                                contactDetailsSerializable.setTelephoneNo(value);
                                break;
                            case 7:
                                contactDetailsSerializable.setMobileNo(value);
                                break;
                            case 8:
                                contactDetailsSerializable.setEmailAddress(value);
                                break;
                            case 9:
                                Calendar cal = Calendar.getInstance();
                                SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
                                cal.setTime(sdf.parse(value));
                                employeeDetailsSerializable.setDateOfBirth(cal);
                                break;
                        }
                        i++;
                    }
                    StringTokenizer s3 = new StringTokenizer(nomi, "^");
                    while (s3.hasMoreTokens()) {
                        StringTokenizer s4 = new StringTokenizer(s3.nextToken(), "||");
                        i = 0;
                        while (s4.hasMoreTokens()) {
                            String value = s4.nextToken();
                            NomineeDetails nomineeDetail = new NomineeDetails();
                            switch (i) {
                                case 1:
                                    nomineeDetail.setFullName(value);
                                    break;
                                case 2:
                                    nomineeDetail.setRelativeInfo(value.toUpperCase());
                                    break;
                                case 3:
                                    nomineeDetail.setRelative(value);
                                    break;
                                case 4:
                                    nomineeDetail.setAge(value);
                                    break;
                                case 5:
                                    nomineeDetail.setProofs(value);
                                    break;
                                case 6:
                                    nomineeDetail.setIdentificationProofs(value);
                                    break;
                                case 7:
                                    nomineeDetail.setRelated(value);
                                    break;
                                case 8:
                                    nomineeDetail.setPercentage(value);
                                    break;
                                case 9:
                                    nomineeDetail.setAddress(value);
                                    break;
                            }
                            i++;
                            nomineeDetails.add(nomineeDetail);
                        }
                    }
                    e.setAddressDetails(addressDetailsSerializable);
                    e.setContactInfo(contactDetailsSerializable);
                    e.setEmployeeDetails(employeeDetailsSerializable);
                    e.setNomineeDetails(nomineeDetails);
                }
            }
        } catch (Exception i) {
            i.printStackTrace();
        }
        return e;
    }
}

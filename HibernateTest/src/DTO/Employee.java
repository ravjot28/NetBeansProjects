package DTO;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    private int SapId;
    private String EmpName;
    private String EmpDOB;
    private String EmpHobbies;

    public String getEmpDOB() {
        return EmpDOB;
    }

    public void setEmpDOB(String EmpDOB) {
        this.EmpDOB = EmpDOB;
    }

    public String getEmpHobbies() {
        return EmpHobbies;
    }

    public void setEmpHobbies(String EmpHobbies) {
        this.EmpHobbies = EmpHobbies;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String EmpName) {
        this.EmpName = EmpName;
    }

    public int getSapId() {
        return SapId;
    }

    public void setSapId(int SapId) {
        this.SapId = SapId;
    }
}

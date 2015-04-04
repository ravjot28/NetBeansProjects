package com.rvp.service;

import com.rvp.dao.InsuranceDAO;
import com.rvp.dto.InsuranceDTO;
import com.rvp.dto.SearchDTO;
import java.text.ParseException;

public class InsuranceService {

    public boolean processNewEntry(InsuranceDTO dto){
        boolean result = false;
        try{
            InsuranceDAO dao = new InsuranceDAO();
            result = dao.processNewEntry(dto);
        }catch(Exception e){
            
        }
        return result;
    }

    public InsuranceDTO editEntrySearch(String ackNo,String appNo){
        InsuranceDTO dto = null;
        InsuranceDAO dao = new InsuranceDAO();
        dto = dao.editEntrySearch(ackNo,appNo);
        //System.out.println(dto.getBankName());
        return dto;
    }

    public SearchDTO searchEntries(SearchDTO dto) throws ParseException, Exception{
        InsuranceDAO dao = new InsuranceDAO();
        dto = dao.searchResults(dto);
        return dto;
    }
}

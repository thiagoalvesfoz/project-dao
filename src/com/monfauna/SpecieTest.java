package com.monfauna;

import com.monfauna.dao.SpecieTypeDao;
import com.monfauna.dao.impl.DaoFactory;
import com.monfauna.model.SpecieType;

import java.util.List;

public class SpecieTest {
    public static void main(String[] args) {

        SpecieTypeDao specieTypeDao = DaoFactory.getSpecieTypeDao();
        List<SpecieType> specieTypes = specieTypeDao.findAll();
        for (SpecieType st : specieTypes){
            System.out.println(st);
        }
    }
}

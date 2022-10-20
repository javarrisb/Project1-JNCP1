package com.company.Summative1CristieJBNicholas.controller;

import com.company.Summative1CristieJBNicholas.models.TaxRate;
import com.company.Summative1CristieJBNicholas.repository.TaxRateRepository;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Min;
import java.awt.*;

public class TaxRateDataLoader {

    @Autowired
    TaxRateRepository taxRateRepository;

    public void loadData() {
        TaxRate Alabama = new TaxRate();
        Alabama.setState("AL");
        Alabama.setRate(.05);

        TaxRate Alaska = new TaxRate();
        Alaska.setState("AK");
        Alaska.setRate(.06);

        TaxRate Arizona = new TaxRate();
        Arizona.setState("AZ");
        Arizona.setRate(.04);

        TaxRate Arkansas = new TaxRate();
        Arkansas.setState("AR");
        Arkansas.setRate(.06);

        TaxRate California = new TaxRate();
        California.setState("CA");
        California.setRate(.06);

        TaxRate Colorado = new TaxRate();
        Colorado.setState("CO");
        Colorado.setRate(.04);

        TaxRate Connecticut = new TaxRate();
        Connecticut.setState("CT");
        Connecticut.setRate(.03);

        TaxRate Delaware = new TaxRate();
        Delaware.setState("DE");
        Delaware.setRate(.05);

        TaxRate Florida = new TaxRate();
        Florida.setState("FL");
        Florida.setRate(.06);

        TaxRate Georgia = new TaxRate();
        Georgia.setState("GA");
        Georgia.setRate(.07);

        TaxRate Hawaii = new TaxRate();
        Hawaii.setState("HI");
        Hawaii.setRate(.05);

        TaxRate Idaho = new TaxRate();
        Idaho.setState("ID");
        Idaho.setRate(.03);

        TaxRate Illinois = new TaxRate();
        Illinois.setState("IL");
        Illinois.setRate(.05);

        TaxRate Indiana = new TaxRate();
        Indiana.setState("IN");
        Indiana.setRate(.05);

        TaxRate Iowa = new TaxRate();
        Iowa.setState("IA");
        Iowa.setRate(.04);

        TaxRate Kansas = new TaxRate();
        Kansas.setState("KS");
        Kansas.setRate(.06);

        TaxRate Kentucky = new TaxRate();
        Kentucky.setState("KY");
        Kentucky.setRate(.04);

        TaxRate Louisiana = new TaxRate();
        Louisiana.setState("LA");
        Louisiana.setRate(.05);

        TaxRate Maine = new TaxRate();
        Maine.setState("ME");
        Maine.setRate(.03);

        TaxRate Maryland = new TaxRate();
        Maryland.setState("MD");
        Maryland.setRate(.07);

        TaxRate Massachusetts = new TaxRate();
        Massachusetts.setState("MA");
        Massachusetts.setRate(.05);

        TaxRate Michigan = new TaxRate();
        Michigan.setState("MI");
        Michigan.setRate(.06);

        TaxRate Minnesota = new TaxRate();
        Minnesota.setState("MN");
        Minnesota.setRate(.06);

        TaxRate Mississippi = new TaxRate();
        Mississippi.setState("MS");
        Mississippi.setRate(.05);

        TaxRate Missouri = new TaxRate();
        Missouri.setState("MO");
        Missouri.setRate(.05);

        TaxRate Montana = new TaxRate();
        Montana.setState("MT");
        Montana.setRate(.03);

        TaxRate Nebraska = new TaxRate();
        Nebraska.setState("NE");
        Nebraska.setRate(.04);

        TaxRate Nevada = new TaxRate();
        Nevada.setState("NV");
        Nevada.setRate(.04);

        TaxRate NewHampshire = new TaxRate();
        NewHampshire.setState("NH");
        NewHampshire.setRate(.06);

        TaxRate NewJersey = new TaxRate();
        NewJersey.setState("NJ");
        NewJersey.setRate(.05);

        TaxRate NewMexico = new TaxRate();
        NewMexico.setState("NM");
        NewMexico.setRate(.05);

        TaxRate NewYork = new TaxRate();
        NewYork.setState("NY");
        NewYork.setRate(.06);

        TaxRate NorthCarolina = new TaxRate();
        NorthCarolina.setState("NC");
        NorthCarolina.setRate(.05);

        TaxRate NorthDakota = new TaxRate();
        NorthDakota.setState("ND");
        NorthDakota.setRate(.05);

        TaxRate Ohio = new TaxRate();
        Ohio.setState("OH");
        Ohio.setRate(.04);

        TaxRate Oklahoma = new TaxRate();
        Oklahoma.setState("OK");
        Oklahoma.setRate(.04);

        TaxRate Oregon = new TaxRate();
        Oregon.setState("OR");
        Oregon.setRate(.07);

        TaxRate Pennsylvania = new TaxRate();
        Pennsylvania.setState("PA");
        Pennsylvania.setRate(.06);

        TaxRate RhodeIsland = new TaxRate();
        RhodeIsland.setState("RI");
        RhodeIsland.setRate(.06);

        TaxRate SouthCarolina = new TaxRate();
        SouthCarolina.setState("SC");
        SouthCarolina.setRate(.06);

        TaxRate SouthDakota = new TaxRate();
        SouthDakota.setState("SD");
        SouthDakota.setRate(.06);

        TaxRate Tennessee = new TaxRate();
        Tennessee.setState("TN");
        Tennessee.setRate(.05);

        TaxRate Texas = new TaxRate();
        Texas.setState("TX");
        Texas.setRate(.03);

        TaxRate Utah = new TaxRate();
        Utah.setState("UT");
        Utah.setRate(.04);

        TaxRate Vermont = new TaxRate();
        Vermont.setState("VT");
        Vermont.setRate(.07);

        TaxRate Virginia = new TaxRate();
        Virginia.setState("VA");
        Virginia.setRate(.06);

        TaxRate Washington = new TaxRate();
        Washington.setState("WA");
        Washington.setRate(.05);

        TaxRate WestVirginia = new TaxRate();
        WestVirginia.setState("WV");
        WestVirginia.setRate(.05);

        TaxRate Wisconsin = new TaxRate();
        Wisconsin.setState("WI");
        Wisconsin.setRate(.03);

        TaxRate Wyoming = new TaxRate();
        Wyoming.setState("WY");
        Wyoming.setRate(.04);
    }
}

package com.briterp.utilities;
import com.briterp.pages.DiscussModulePage;
import com.briterp.pages.LoginPage;
import com.briterp.pages.OdooFirstPage;
import com.briterp.pages.PointOfSale;


public class Pages {

    private OdooFirstPage odooFirstPage;
    private LoginPage loginPage;
    private DiscussModulePage discussModulePage;
    private PointOfSale pointOfSale;


   public OdooFirstPage odoo(){
        if(odooFirstPage==null){
            odooFirstPage = new OdooFirstPage();
        }
        return odooFirstPage;

   }

    public LoginPage loginPage(){
        if(loginPage==null){
            loginPage = new LoginPage();
        }
        return loginPage;

    }




    public DiscussModulePage  discussModulePage(){
        if(discussModulePage==null){
            discussModulePage = new DiscussModulePage();
        }
        return discussModulePage;

    }
    public PointOfSale  pointOfSale(){
        if(pointOfSale==null){
            pointOfSale = new PointOfSale();
        }
        return pointOfSale;

    }






}


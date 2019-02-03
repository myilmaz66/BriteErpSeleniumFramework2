package com.briterp.utilities;
import com.briterp.pages.*;


public class Pages {

    private OdooFirstPage odooFirstPage;
    private LoginPage loginPage;
    private DiscussModulePage discussModulePage;
    private PointOfSalePage pointOfSalePage;
    private PricelistsPage pricelistsPage;


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

    public PointOfSalePage pointOfSale(){
        if(pointOfSalePage ==null){
            pointOfSalePage = new PointOfSalePage();
        }
        return pointOfSalePage;

    }

    public PricelistsPage pricelists(){
        if(pricelistsPage ==null){
            pricelistsPage = new PricelistsPage();
        }
        return pricelistsPage;
    }






}


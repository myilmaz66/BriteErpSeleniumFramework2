package com.briterp.utilities;
import com.briterp.pages.DiscussModulePage;
import com.briterp.pages.LoginPage;
import com.briterp.pages.OdooFirstPage;


public class Pages {

    private OdooFirstPage odooFirstPage;
    private LoginPage loginPage;
    private Methods methods;
    private DiscussModulePage discussModulePage;


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

    public Methods methods(){
        if(methods==null){
            methods = new Methods();
        }
        return methods;

    }
    public DiscussModulePage  discussModulePage(){
        if(discussModulePage==null){
            discussModulePage = new DiscussModulePage();
        }
        return discussModulePage;

    }
}


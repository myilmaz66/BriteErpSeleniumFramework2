package com.briterp.utilities;

import com.briterp.pages.*;


public class Pages {

    private OdooFirstPage odooFirstPage;
    private LoginPage loginPage;
    private DiscussModulePage discussModulePage;
    private PointOfSale pointOfSale;
    private OrdersPage orderspage;

    public OdooFirstPage odoo() {
        if (odooFirstPage == null) {
            odooFirstPage = new OdooFirstPage();
        }
        return odooFirstPage;

    }

    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;

    }


    public DiscussModulePage discussModulePage() {
        if (discussModulePage == null) {
            discussModulePage = new DiscussModulePage();
        }
        return discussModulePage;

    }

    public PointOfSale pointOfSale() {
        if (pointOfSale == null) {
            pointOfSale = new PointOfSale();
        }
        return pointOfSale;

    }

    public OrdersPage orders() {
        if (orderspage == null) {
            orderspage = new OrdersPage();
        }
        return orderspage;

    }


}


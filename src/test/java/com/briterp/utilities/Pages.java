package com.briterp.utilities;

import com.briterp.pages.*;


public class Pages {

    private OdooFirstPage odooFirstPage;
    private LoginPage loginPage;
    private DiscussModulePage discussModulePage;
    private PointOfSalePage pointOfSalePage;
    private PricelistsPage pricelistsPage;
    private OrdersPage orderspage;
    private PricelistEditCreatePage pricelistEditCreatePage;
    private CreatePricelistItemsPage createPricelistItemsPage;
    private PricelistSaveDiscardPage pricelistSaveDiscardPage;

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

    public PointOfSalePage pointOfSale(){
        if(pointOfSalePage ==null) {
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


    public OrdersPage orders() {
        if (orderspage == null) {
            orderspage = new OrdersPage();
        }
        return orderspage;

    }

    public PricelistEditCreatePage pricelistEditCreate(){
        if (pricelistEditCreatePage == null){
            pricelistEditCreatePage = new PricelistEditCreatePage();
        }
        return pricelistEditCreatePage;
    }

    public CreatePricelistItemsPage createPricelistItems() {
        if (createPricelistItemsPage==null){
            createPricelistItemsPage=new CreatePricelistItemsPage();
        }
        return createPricelistItemsPage;
    }

    public PricelistSaveDiscardPage pricelistSaveDiscardPage() {
        if (pricelistSaveDiscardPage == null) {
            pricelistSaveDiscardPage = new PricelistSaveDiscardPage();
        }
        return pricelistSaveDiscardPage;

    }
}


package com.briterp.utilities;
<<<<<<< HEAD
=======

>>>>>>> 89909f71fe4becd4f3a7d3a0e2e2b38d4ec3aa4d
import com.briterp.pages.*;


public class Pages {

    private OdooFirstPage odooFirstPage;
    private LoginPage loginPage;
    private DiscussModulePage discussModulePage;
<<<<<<< HEAD
    private PointOfSalePage pointOfSalePage;
    private PricelistsPage pricelistsPage;
=======
    private PointOfSale pointOfSale;
    private OrdersPage orderspage;
>>>>>>> 89909f71fe4becd4f3a7d3a0e2e2b38d4ec3aa4d

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

<<<<<<< HEAD
    public DiscussModulePage  discussModulePage(){
        if(discussModulePage==null){
=======

    public DiscussModulePage discussModulePage() {
        if (discussModulePage == null) {
>>>>>>> 89909f71fe4becd4f3a7d3a0e2e2b38d4ec3aa4d
            discussModulePage = new DiscussModulePage();
        }
        return discussModulePage;

    }

<<<<<<< HEAD
    public PointOfSalePage pointOfSale(){
        if(pointOfSalePage ==null){
            pointOfSalePage = new PointOfSalePage();
=======
    public PointOfSale pointOfSale() {
        if (pointOfSale == null) {
            pointOfSale = new PointOfSale();
>>>>>>> 89909f71fe4becd4f3a7d3a0e2e2b38d4ec3aa4d
        }
        return pointOfSalePage;

    }

<<<<<<< HEAD
    public PricelistsPage pricelists(){
        if(pricelistsPage ==null){
            pricelistsPage = new PricelistsPage();
        }
        return pricelistsPage;
    }

=======
    public OrdersPage orders() {
        if (orderspage == null) {
            orderspage = new OrdersPage();
        }
        return orderspage;
>>>>>>> 89909f71fe4becd4f3a7d3a0e2e2b38d4ec3aa4d

    }


}


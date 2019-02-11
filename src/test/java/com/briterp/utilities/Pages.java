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
    private CountryGroupsPage countryGroupsPage;
    private PointOfSaleModulePage pointOfSaleModulePage;
    private ProductsPage productsPage;
    private ProductsSaveDiscardPage productsSaveDiscardPage;
    private ProductsEditCreatePage productsEditCreatePage;
    private ListViewPage listViewPage;

    public ListViewPage listViewPage() {
        if (listViewPage == null) {
            listViewPage = new ListViewPage();
        }
        return listViewPage;
    }

    public ProductsEditCreatePage productsEditCreatePage() {
        if (productsEditCreatePage == null) {
            productsEditCreatePage = new ProductsEditCreatePage();
        }
        return productsEditCreatePage;
    }

    public ProductsSaveDiscardPage productsSaveDiscardPage() {
        if (productsSaveDiscardPage == null) {
            productsSaveDiscardPage = new ProductsSaveDiscardPage();
        }
        return productsSaveDiscardPage;
    }
    public ProductsPage productsPage() {
        if (productsPage == null) {
            productsPage = new ProductsPage();
        }
        return productsPage;
    }

    public PointOfSaleModulePage pointOfSaleModulePage() {
        if (pointOfSaleModulePage == null) {
            pointOfSaleModulePage = new PointOfSaleModulePage();
        }
        return pointOfSaleModulePage;
    }

    public CountryGroupsPage countryGroupsPage() {
        if (countryGroupsPage == null) {
            countryGroupsPage = new CountryGroupsPage();
        }
        return countryGroupsPage;
    }

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

    public PointOfSalePage pointOfSale() {
        if (pointOfSalePage == null) {
            pointOfSalePage = new PointOfSalePage();
        }
        return pointOfSalePage;
    }

    public PricelistsPage pricelists() {
        if (pricelistsPage == null) {
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

    public PricelistEditCreatePage pricelistEditCreate() {
        if (pricelistEditCreatePage == null) {
            pricelistEditCreatePage = new PricelistEditCreatePage();
        }
        return pricelistEditCreatePage;
    }

    public CreatePricelistItemsPage createPricelistItems() {
        if (createPricelistItemsPage == null) {
            createPricelistItemsPage = new CreatePricelistItemsPage();
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


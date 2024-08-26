package com.hitsuni.section02.update;

public class Menu {
    private String menuName;
    private int menuPrice;
    private int menuCode;

    public Menu(int menuCode, String menuName, int menuPrice, int categoryCode, String orderAbleStatus) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuCode = menuCode;
    }

    public Menu(String menuName, int menuPrice, int menuCode) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", menuCode=" + menuCode +
                '}';
    }
}

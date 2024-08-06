package ru.bi.kovaleva;

public class BasketApp {
    public static void main(String[] args) {
        Basket basket = new BasketImpl(); //корзина пуста

        //добавление продуктов в корзину
        basket.addProduct("Product_1", 10);
        basket.addProduct("Product_2", 20);
        //basket.addProduct("", 0);

        //получить список продуктов
        System.out.println(basket.getProducts());

        //изменить количество продукта
        basket.updateProductQuantity("Product_2", 10);

        //получить количество продукта
        basket.getProductQuantity("Product_2");

        //удаление продукта
        basket.removeProduct("Product_1");
        //basket.removeProduct("Test");

        //очистить коризину
        basket.clear();

    }
}

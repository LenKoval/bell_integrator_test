package ru.bi.kovaleva;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasketImpl implements Basket {

    private Map<String, Integer> products = new HashMap<>();

    private static final Logger logger = LoggerFactory.getLogger(BasketImpl.class);

    @Override
    public void addProduct(String product, int quantity) {
        if (product.isEmpty() || quantity == 0) {
            throw new EmptyProductException("The entered string cannot be empty.");
        }

        products.put(product, quantity);
        logger.info("Продукт " + product + " количество " + quantity + " добавлен в корзину.");
    }

    @Override
    public void removeProduct(String product) {
        if (products.containsKey(product)) {
            products.remove(product);
            logger.info("Продукт " + product + " удален из корзины.");
        } else {
            throw new EmptyProductException("Product " + product + " not found.");
        }
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        if (products.containsKey(product)) {
            products.merge(product, quantity, Integer::sum);
            logger.info("Количество продукта " + product + " изменено на " + products.get(product));
        } else {
            throw new EmptyProductException("Product " + product + " not found.");
        }
    }

    @Override
    public void clear() {
        products.clear();
        logger.info("Корзина очищена.");
    }

    @Override
    public List<String> getProducts() {
        return new ArrayList<>(products.keySet());
    }

    @Override
    public int getProductQuantity(String product) {
        if (!products.containsKey(product)) {
            throw new EmptyProductException("Product " + product + " not found.");
        }

        int quantity = products.get(product);
        logger.info("Количество продукта " + product + " = " + quantity);
        return quantity;
    }
}

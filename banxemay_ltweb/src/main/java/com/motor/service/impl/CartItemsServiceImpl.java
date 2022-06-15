package com.motor.service.impl;

import com.motor.dao.ICartItemsDAO;
import com.motor.dao.impl.CartItemsDAOImpl;
import com.motor.model.CartItems;
import com.motor.service.ICartItemsService;

import java.util.List;

public class CartItemsServiceImpl implements ICartItemsService {
    //    @Inject
    ICartItemsDAO cartItemsDAO = new CartItemsDAOImpl();

    @Override
    public void insert(CartItems cartItem) {
       cartItemsDAO.insert(cartItem);
    }

    @Override
    public void edit(CartItems cartItem) {
       cartItemsDAO.edit(cartItem);
    }

    @Override
    public void delete(int id) {
        cartItemsDAO.delete(id);
    }

    @Override
    public CartItems get(int id) {

        return null;
    }

    @Override
    public List<CartItems> getAll() {
        return cartItemsDAO.getAll();
    }

    public List<CartItems> search(String name) {
        return null;
    }

    @Override
    public CartItems get(String name) {
        return null;
    }
}

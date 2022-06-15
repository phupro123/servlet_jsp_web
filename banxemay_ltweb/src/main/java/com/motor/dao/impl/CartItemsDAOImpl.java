package com.motor.dao.impl;

import com.motor.dao.ICartItemsDAO;
import com.motor.dao.ICategoryDAO;
import com.motor.mapper.AbstractDAO;
import com.motor.model.CartItems;
import com.motor.model.Category;

import java.util.List;

public class CartItemsDAOImpl extends AbstractDAO<CartItems> implements ICartItemsDAO {
    @Override
    public void insert(CartItems cartItem) {

    }

    @Override
    public void edit(CartItems cartItem) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public CartItems get(String name) {
        return null;
    }

    @Override
    public CartItems get(int id) {
        return null;
    }

    @Override
    public List<CartItems> getAll() {
        return null;
    }

    @Override
    public List<CartItems> search(String name) {
        return null;
    }
}

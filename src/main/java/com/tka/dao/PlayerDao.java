package com.tka.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Player;

@Repository
public class PlayerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Player save(Player player) {
    	Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(player);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
        return player;
    }

    public Player findById(Long id) {
    	Session session = sessionFactory.openSession();
        try {
            return session.get(Player.class, id);
        } finally {
            session.close();
        }
    }

    public List<Player> findAll() {
    	 Session session = sessionFactory.openSession();
    	    try {
    	        Criteria criteria = session.createCriteria(Player.class);
    	        return criteria.list();
    	    } finally {
    	        session.close();
    	    }
    }
}

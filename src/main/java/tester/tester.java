/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entity.DiscountFixed;
import entity.DiscountQuantity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rasmus
 */
public class tester {
    public static void main(String[] args) {
        Persistence.generateSchema("pu", null);
        DiscountFixed df = new DiscountFixed();
        DiscountQuantity dq = new DiscountQuantity();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu"); 
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(df);
            em.persist(dq);
            em.getTransaction().commit();
        } finally{
            if(em != null){
                em.close();
            }
        }
    }
}

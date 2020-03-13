package com.pangtrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * User: SeungHo Lee (seung7642@gmail.com)
 * Date: 2020. 3. 13.
 * Time: 오전 11:50
 */
public class Main {

    public static void main(String[] args) {

        // 1. 엔티티 매니저팩토리 생성.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pangtrue");

        // 2. 엔티티 매니저 생성.
        EntityManager em = emf.createEntityManager();

        // 3. 트랜잭션 기능을 담당하는 객체 생성.
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            logic(em);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

    private static void logic(EntityManager em) {
        String id = "pangtrue";
        Member member = new Member();
    }
}

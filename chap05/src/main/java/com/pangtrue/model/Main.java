package com.pangtrue.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pangtrue");
        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();

        try {
            tx.begin(); // 트랜잭션 시작
            // TODO : 비즈니스 로직
            tx.commit(); // 트랜잭션 커밋
        } catch (Exception ex) {
            ex.getMessage();
            tx.rollback();
        } finally {
            entityManager.close();
        }

        emf.close();
    }
}

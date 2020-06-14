package com.pangtrue.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * User: SeungHo Lee (seung7642@gmail.com)
 * Date: 2020. 3. 13.
 * Time: 오전 11:50
 */
public class Main {

    public static void main(String[] args) {

        // 1. 'pangtrue'명을 가진 persistence-unit을 참조해 EntityManagerFactory 생성.
        //    EntityManagerFactory를 생성하는 비용은 아주 크다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pangtrue");

        // 2. 엔티티 매니저 생성.
        EntityManager em = emf.createEntityManager();

        // 3. EntityManager로부터 트랜잭션 기능을 담당하는 객체 생성.
        EntityTransaction tx = em.getTransaction();

        try {
            // 1. 트랜잭션을 시작한다.
            tx.begin();

            // 2. 비즈니스 로직을 실행한다.
            logic(em);

            // 3. 트랜잭션을 커밋한다.
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

    private static void logic(EntityManager em) {
        Long id = 4L;
        Member member = new Member();
        member.setId(id);
        member.setUserName("Seungho Lee");
        member.setAge(25);

        // 1. Persistence Context에 엔티티를 등록한다.
        em.persist(member);

        // 2. update
        member.setAge(30);

        // 3. select one
        Member findMember = em.find(Member.class, id);
        System.out.println("findMember : " + findMember);

        // 4. select list
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        System.out.println("members.size : " + members.size());

        // 5. delete
        em.remove(member);
    }
}

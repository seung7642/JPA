package com.pangtrue;

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
        member.setId(id);
        member.setUserName("pangtrue");
        member.setAge(10);

        // 1. Persistence Context에 엔티티를 등록한다.
        em.persist(member);

        // 2. update
        member.setAge(20);

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

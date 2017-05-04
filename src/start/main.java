package start;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import Entities.Posts;
import Entities.User;

public class main {

  public static void main(String[] args) {
    // SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    // Session session = sessionFactory.openSession();
    // session.beginTransaction();
    // Posts posts = new Posts();
    // posts.setName("dfgh");
    // posts.setUrl("ppp");
    // session.save(posts);
    // session.getTransaction().commit();
    // session.close();
    SessionFactory fact = new Configuration().configure().buildSessionFactory();
    Session session = fact.openSession();
    session.beginTransaction();

    // criteria to get All user Entity
    Criteria criteria = session.createCriteria(User.class);
    // to add Condition To Criteria
    Criteria c = criteria.add(Restrictions.eq("id", 2));
    // get specific user
    User us = (User) c.uniqueResult();
    // make post to specific user that id= 2
    Posts p = new Posts();
    p.setName("ddddddkkkkkkkk");
    p.setUrl("ddlllllllllssssss");
    // ----------------- set post to the user ----------------
    p.setUser(us);
    session.save(p);
    session.getTransaction().commit();
    session.close();

  }
}

package ua.lviv.dvoretskyi.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppEntryPoint {

  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Library");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();

    entityManager.getTransaction().commit();
    entityManager.close();
    entityManagerFactory.close();
  }
}


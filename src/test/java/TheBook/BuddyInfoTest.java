package TheBook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    BuddyInfo buddy;
    @Before
    public void setUp() throws Exception {
        buddy = new BuddyInfo("Tom", "Carleton", "613");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getName() {
        assertTrue(buddy.getName().equals("Tom"));
    }

    @Test
    public void setName() {
        buddy.setName("Ted");
        assertTrue(buddy.getName().equals("Ted"));
    }

    @Test
    public void getAddress() {
        assertTrue(buddy.getAddress().equals("Carleton"));
    }

    @Test
    public void setAddress() {
        buddy.setAddress("Home");
        assertTrue(buddy.getAddress().equals("Home"));
    }

    @Test
    public void getPhoneNumber() {
        assertTrue(buddy.getPhoneNumber().equals("613"));
    }

//    @Test
//    public void setPhoneNumber() {
//        buddy.setPhoneNumber("865");
//        assertTrue(buddy.getPhoneNumber().equals("865"));
//    }
//
//    @Test
//    public void performJPA() {
//        BuddyInfo buddy1 = new BuddyInfo();
//        buddy1.setId(1);
//        buddy1.setName("Bill");
//        buddy1.setAddress("Home");
//        buddy1.setPhoneNumber("865");
//
//        BuddyInfo buddy2 = new BuddyInfo();
//        buddy2.setId(2);
//        buddy2.setName("Fred");
//        buddy2.setAddress("Home");
//        buddy2.setPhoneNumber("865");
//
//        // Connecting to the database through EntityManagerFactory
//        // connection details loaded from persistence.xml
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
//
//        EntityManager em = emf.createEntityManager();
//
//        // Creating a new transaction
//        EntityTransaction tx = em.getTransaction();
//
//        tx.begin();
//
//        // Persisting the product entity objects
//        em.persist(buddy1);
//        em.persist(buddy2);
//
//        tx.commit();
//
//        // Querying the contents of the database using JPQL query
//        Query q = em.createQuery("SELECT p FROM BuddyInfo p");
//
//        @SuppressWarnings("unchecked")
//        List<BuddyInfo> results = q.getResultList();
//
//        System.out.println("List of buddies\n----------------");
//
//        for (BuddyInfo p : results) {
//            System.out.println(p.getName() + " (id=" + p.getId() + ")");
//        }
//
//        // Closing connection
//        em.close();
//
//        emf.close();
//    }
}
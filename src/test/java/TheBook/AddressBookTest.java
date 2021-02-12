package TheBook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressBookTest {

    AddressBook addressBook;

    @Before
    public void setUp() throws Exception {
        addressBook = new AddressBook("test");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addBuddy() {
        BuddyInfo buddy = new BuddyInfo("Fred", "Carleton", "865");
        addressBook.addBuddy(buddy);
        //BuddyInfo testBuddy = addressBook.getBuddyInfos().contains(buddy);
        assertTrue(addressBook.getBuddyInfos().contains(buddy));
    }

    @Test
    public void removeBuddy() {
        BuddyInfo buddy = new BuddyInfo("Fred", "Carleton", "865");
        addressBook.addBuddy(buddy);
        addressBook.removeBuddy(buddy.getId());
        assertFalse(addressBook.getBuddyInfos().contains(
                new BuddyInfo("Tom", "Carleton", "613")));
    }

//    @Test
//    public void performJPA() {
//
//        // Creating objects representing some products
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
//        addressBook.addBuddy(buddy1);
//        addressBook.addBuddy(buddy2);
//        em.persist(buddy1);
//        em.persist(buddy2);
//        em.persist(addressBook);
//
//        tx.commit();
//
//        // Querying the contents of the database using JPQL query
//        Query q = em.createQuery("SELECT p FROM AddressBook p");
//
//        @SuppressWarnings("unchecked")
//        List<AddressBook> results = q.getResultList();
//
//        System.out.println("List of AddressBooks\n----------------");
//
//        for (AddressBook p : results) {
//            System.out.println(p.getId());
//            //p.print();
//        }
//
//        // Closing connection
//        em.close();
//
//        emf.close();
//    }

}
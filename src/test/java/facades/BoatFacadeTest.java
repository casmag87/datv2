/*package facades;

import entities.Auction;
import entities.Boat;
import entities.DTO.AuctionDTO;
import entities.DTO.BoatDTO;
import entities.DTO.UserDTO;
import entities.User;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@Disabled
public class BoatFacadeTest {

    private static EntityManagerFactory emf;
    private static OwnerFacade facade;

    @BeforeAll
    public static void beforeAll(){

        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = OwnerFacade.getOwnerFacade(emf);

    }


    @AfterAll
    public static void tearDownClass(){

    }

    @BeforeEach
    public void setUP(){
        EntityManager em = emf.createEntityManager();


        User user = new User("user","test1");



        try{
            em.getTransaction().begin();
            Boat boat = new Boat(1L,"test","test","test","test","test");
            user.addBoat(boat);
            em.persist(boat);
            em.persist(user);
            em.getTransaction().commit();

        }finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown(){
    }



    @Test
    void getOwnerBoat() {

        List<BoatDTO> boatDTOList = facade.getOwnerBoats("user");

        assertFalse(boatDTOList.isEmpty());

    }






}
*/
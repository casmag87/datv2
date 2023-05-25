package facades;

import entities.Boat;
import entities.DTO.BoatDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;
import java.util.ArrayList;
import java.util.List;

public class OwnerFacade {

    private static EntityManagerFactory emf;
    private static OwnerFacade instance;

    public OwnerFacade() {
    }

    public static OwnerFacade getOwnerFacade(EntityManagerFactory _emf){
        if (instance == null) {
            emf = _emf;
            instance = new OwnerFacade();
        }
        return instance;
    }


    public List<BoatDTO> getOwnerBoats(String name) {
        EntityManager em = emf.createEntityManager();

        List<Boat> boatList;
        try {
            TypedQuery<Boat> query = em.createQuery("SELECT b from boat b join b.userList u where u.userName =:name", Boat.class)
                    .setParameter("name", name);

            boatList = query.getResultList();

            if (boatList.isEmpty()) {
                throw new WebApplicationException("empty");
            }


        } finally {
            em.close();
        }

        List<BoatDTO> boatDTOList = new ArrayList<>();
        boatList.forEach(boat -> boatDTOList.add(new BoatDTO(boat.getId(), boat.getName(), boat.getBrand(), boat.getMake(), boat.getYear(), boat.getImageUrl())));
        return boatDTOList;
    }


    public BoatDTO deleteById(Long Id){

        EntityManager em =emf.createEntityManager();

        Boat boat  = em.find(Boat.class,Id);

        if (boat == null){
            throw new WebApplicationException("no boats with that id");
        }

        try{
            em.getTransaction().begin();
            em.remove(boat);
            em.getTransaction().commit();
            return new BoatDTO(boat);
        }finally {
            em.close();
        }


    }



}

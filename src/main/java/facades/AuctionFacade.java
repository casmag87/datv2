package facades;

import entities.Auction;
import entities.DTO.AuctionDTO;
import entities.DTO.BoatDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;
import java.util.ArrayList;
import java.util.List;

public class AuctionFacade {

    private static EntityManagerFactory emf;
    private static AuctionFacade instance;

    public AuctionFacade() {
    }

    public static AuctionFacade getAuctionFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new AuctionFacade();
        }
        return instance;
    }

    public List<AuctionDTO> getAllAuctions() {
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<AuctionDTO> query = em.createQuery("SELECT a FROM auction a",AuctionDTO.class);
            List<AuctionDTO> auctionDTOList = query.getResultList();
            if(auctionDTOList.isEmpty()){
                throw new WebApplicationException("the database does not contain any auctions!");
            }

            return auctionDTOList;
        }finally {
            em.close();
        }
    }

    public AuctionDTO createAuction(AuctionDTO auctionDTO){
        Auction auction = new Auction(auctionDTO);
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(auction);
            em.getTransaction().commit();

        }finally {
            em.close();
        }


        return new AuctionDTO(auction);
    }

    public AuctionDTO deleteByID(Long Id){
        EntityManager em = emf.createEntityManager();

        Auction auction = em.find(Auction.class,Id);

        if(auction == null){
            throw new WebApplicationException("no auction with that id ");
        }

        try{
            em.getTransaction().begin();
            em.remove(auction);
            em.getTransaction().commit();
            return new AuctionDTO(auction);
        }finally {
            em.close();
        }


    }



}

package ie.domis.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ie.domis.domain.Bid;
import ie.domis.domain.Job;
import ie.domis.domain.User;

public interface BidDAO extends JpaRepository<Bid, Integer> {
	
	List<Bid> findAllBidsByBidder(User bidder);
	List<Bid> findAllBidsByJob(Job job);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE bid SET bidder= :bidder WHERE bidId= :id", nativeQuery= true)
	int updateBidderInBidById(@Param("bidder") User bidder, @Param("id") int id);

	@Modifying
	@Transactional
	@Query(value="UPDATE bid SET job= :job WHERE bidId= :id", nativeQuery= true)
	int updateJobInBidById(@Param("job") Job job, @Param("id") int id);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE bid SET value= :value WHERE bidId= :id", nativeQuery= true)
	int updateValueInBidById(@Param("value") float value, @Param("id") int id);

}

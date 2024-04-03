package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.springframework.beans.factory.annotation.Autowired;

// Singleton !!!
public class TripService {

	@Autowired
	private TripDAO tripDAO;

	public TripService(TripDAO tripDAO) {
		this.tripDAO = tripDAO;
	}

	public List<Trip> getTripsByUser(User loggedUser, User user) throws UserNotLoggedInException {
//		User loggedUser = getLoggedUser();

		if (loggedUser == null) throw new UserNotLoggedInException();

		return user.isFriendWith(loggedUser) ? TripDAO.tripsBy(user) : new ArrayList<Trip>();
    }
}

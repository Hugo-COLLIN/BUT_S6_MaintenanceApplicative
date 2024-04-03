package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TripServiceTest {

    private static final User GUEST = null;
    private static final User UNUSED_USER = null;
    private static final User REGISTERED_USER = new User();
    private static final User LOGGED_USER = new User();
    private static final User ANOTHER_USER = new User();

    private User loggedInUser;

	public class TestableTripService extends TripService {
        @Override
        protected User getLoggedUser() {
            return loggedInUser;
        }
    }

//    public static class TestableTripDAO extends TripDAO {
//        @Override
//        public static List<Trip> findTripsByUser(User user) {
//            List<Trip> trips = new ArrayList<Trip>();
//            trips.add(new Trip());
//            return trips;
//        }
//    }

    @Test
    void shouldThrowsWhenUserIsNotLoggedIn() {
        // Given
        TripService tripService = new TestableTripService();
        loggedInUser = GUEST;

        // When
        // Then
         assertThrows(UserNotLoggedInException.class,
                 () -> tripService.getTripsByUser(UNUSED_USER)
         );
    }

    @Test
    void shouldNotReturnTripsWhenLoggedUserIsNotAFriend() {
        //GIVEN
        TripService tripService = new TestableTripService();
        loggedInUser = REGISTERED_USER;

        //WHEN
        List<Trip> result = tripService.getTripsByUser(ANOTHER_USER);

        //THEN
        assertEquals(0, result.size());
    }

    @Test
    void shouldReturnTripsWhenLoggedUserIsAFriend() {
        //GIVEN
        TripService tripService = new TestableTripService();
        loggedInUser = REGISTERED_USER;
        User anotherUser = ANOTHER_USER;
        loggedInUser.addFriend(anotherUser);
        anotherUser.addFriend(loggedInUser);

        //WHEN
        List<Trip> result = tripService.getTripsByUser(anotherUser);

        System.out.println(result);

        //THEN
        assertEquals(1, result.size());
//        assertEquals(ANOTHER_USER, result.get(0));

    }


    ////Connecté demande liste ami
    //    @Test
    //    void shouldReturnEmptyListWhen
    //
    //    //Connecté demande liste pas ami
    //    @Test
    //    void shouldReturnEmptyListWhenQueryListNotFriends
}

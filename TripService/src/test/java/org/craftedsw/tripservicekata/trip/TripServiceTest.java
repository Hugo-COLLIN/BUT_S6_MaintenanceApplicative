package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TripServiceTest {

    private static final User GUEST = null;
    private static final User UNUSED_USER = null;
    private static final User REGISTERED_USER = new User();
    private static final User LOGGED_USER = new User();
    private static final User ANOTHER_USER = new User();

    private static final Trip TO_BRAZIL = new Trip();
    private static final Trip TO_LONDON = new Trip();
    private static final Trip TO_SZIGET = new Trip();

    private User loggedInUser;

    private TripService tripService;

	public class TestableTripService extends TripService {
        @Override
        protected User getLoggedUser() {
            return loggedInUser;
        }

        @Override
        protected List<Trip> getTripList(User user) {
            return user.trips();
        }
    }

    @Test
    void shouldThrowsWhenUserIsNotLoggedIn() {
        // Given
        tripService = new TestableTripService();
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
        tripService = new TestableTripService();
        loggedInUser = REGISTERED_USER;
        User anotherUser = ANOTHER_USER;

        anotherUser.addFriend(new User());
        anotherUser.addTrip(TO_SZIGET);

        //WHEN
        List<Trip> result = tripService.getTripsByUser(anotherUser);

        //THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnTripsWhenLoggedUserIsAFriend() {
        //GIVEN
        tripService = new TestableTripService();
        loggedInUser = REGISTERED_USER;

        User user = new User();
        user.addFriend(ANOTHER_USER);
        user.addFriend(loggedInUser);
        user.addTrip(TO_BRAZIL);
        user.addTrip(TO_LONDON);

        //WHEN
        List<Trip> result = tripService.getTripsByUser(user);

        //THEN
        assertAll(
                () -> assertEquals(2, result.size()),
                () -> assertTrue(result.contains(TO_BRAZIL)),
                () -> assertTrue(result.contains(TO_LONDON))
        );
    }
}

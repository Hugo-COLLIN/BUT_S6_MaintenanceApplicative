package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

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

    @Mock
    private TripDAO tripDAO;
    @InjectMocks
    @Spy
    private TripService tripService;

//	public class TestableTripService extends TripService {
//        @Override
//        protected User getLoggedUser() {
//            return loggedInUser;
//        }
//
//        protected List<Trip> getTripList(User user) {
//            return user.trips();
//        }
//    }

    @Test
    void shouldThrowsWhenUserIsNotLoggedIn() {
        // Given
        tripService = new TripService(tripDAO);
        loggedInUser = GUEST;

        // When
        // Then
         assertThrows(UserNotLoggedInException.class,
                 () -> tripService.getTripsByUser(GUEST, UNUSED_USER)
         );
    }

    @Test
    void shouldNotReturnTripsWhenLoggedUserIsNotAFriend() {
        //GIVEN
        tripService = new TripService(tripDAO);
        User user = UserBuilder
                .createUser()
                .withFriends(ANOTHER_USER)
                .withTrips(TO_BRAZIL)
                .build();

        //WHEN
        List<Trip> result = tripService.getTripsByUser(REGISTERED_USER, user);

        //THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnTripsWhenLoggedUserIsAFriend() {
        //GIVEN
        tripService = new TripService(tripDAO);
        loggedInUser = REGISTERED_USER;

        User user = new User();
        user.addFriend(ANOTHER_USER);
        user.addFriend(loggedInUser);
        user.addTrip(TO_BRAZIL);
        user.addTrip(TO_LONDON);

        //WHEN
        List<Trip> result = tripService.getTripsByUser(LOGGED_USER, user);

        //THEN
        assertAll(
                () -> assertEquals(2, result.size()),
                () -> assertTrue(result.contains(TO_BRAZIL)),
                () -> assertTrue(result.contains(TO_LONDON))
        );
    }
}

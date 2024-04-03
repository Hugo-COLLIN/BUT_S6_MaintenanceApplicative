package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.trip.Trip;

import java.util.ArrayList;
import java.util.List;

public class UserBuilder {

	public static UserBuilder cerateUser() {
		return new UserBuilder();
	}

	public User build() {
		User user = new User();
		return user;
	}

//	void WANNADOTHIS {
//		User u = createUser()
//				.withFriends(new User(), new User(), new User())
//				.withTrips(new Trip())
//				.build();
//	}
}

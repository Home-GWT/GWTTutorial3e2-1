package com.hellomvp.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.hellomvp.client.view.GoodbyeView;
import com.hellomvp.client.view.HelloView;

public interface ClientFactory {
	EventBus getEventBus();
	PlaceController getPlaceController();
	HelloView getHelloView();
	GoodbyeView getGoodbyeView();
}

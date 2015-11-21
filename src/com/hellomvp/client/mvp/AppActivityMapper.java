package com.hellomvp.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.hellomvp.client.ClientFactory;
import com.hellomvp.client.activity.GoodbyeActivity;
import com.hellomvp.client.activity.HelloActivity;
import com.hellomvp.client.place.GoodbyePlace;
import com.hellomvp.client.place.HelloPlace;

public class AppActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;

	/**
	 * 'AppActivityMapper' связывает каждую <страницу> с соответствующей 
	 * (Фабрика 'ClientFactory' будет принимать клиентские собития-действия...)
	 */
	public AppActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	/**
	 * Карта: для каждой <странице> соответствует 'Activity' (Это нужно для использования 'GIN') >> http://habrahabr.ru/post/113121/ -- в реальных проектах для задач, которые решает ClientFactory лучше воспользоваться Google GIN’ом...
	 */
	@Override
	public Activity getActivity(Place place) {
		// This is begging for GIN
		if (place instanceof HelloPlace)
			return new HelloActivity((HelloPlace) place, clientFactory);
		else if (place instanceof GoodbyePlace)
			return new GoodbyeActivity((GoodbyePlace) place, clientFactory);

		return null;
	}

}

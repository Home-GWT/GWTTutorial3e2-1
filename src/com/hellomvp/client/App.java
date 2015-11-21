package com.hellomvp.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.activity.shared.*;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.*;
import com.hellomvp.client.mvp.*;
import com.hellomvp.client.place.*;

public class App implements EntryPoint {
	
	private Place    defaultPlace = new HelloPlace("World!");
	private SimplePanel appWidget = new SimplePanel();

	@Override
	public void onModuleLoad(){
		// Создает 'ClientFactory', использует [отложенного связывания] так что мы можем заменить его с разными реализациями в 'gwt.xml'
		ClientFactory         clientFactory = GWT.create(ClientFactory.class);
		EventBus                   eventBus = clientFactory.getEventBus();
		PlaceController     placeController = clientFactory.getPlaceController();

		// Стартует 'ActivityManager' для нашего главного виджета 'ActivityMapper'
		ActivityMapper       activityMapper = new AppActivityMapper(clientFactory);
		ActivityManager     activityManager = new ActivityManager(activityMapper,eventBus);
		activityManager.setDisplay(appWidget);

		// Стартует 'PlaceHistoryHandler' с нашим 'PlaceHistoryMapper'
		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler  historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController,eventBus,defaultPlace);

		RootPanel.get().add(appWidget);
		// Переходит на адресс <представления> (ВИДЖЕТА) по URL-у или по дефолтному адрессу
		historyHandler.handleCurrentHistory();
	}
}

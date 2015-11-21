package com.hellomvp.client.view;


import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.*;

/**
 * View interface. Extends IsWidget so a view impl can easily provide its container widget.
 */
public interface HelloView extends IsWidget{
	void setName(String helloName);
	void setPresenter(Presenter listener);

	public interface Presenter{
		void goTo(Place place);
	}
}
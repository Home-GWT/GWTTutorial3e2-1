package com.hellomvp.client.view;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * View interface. Extends IsWidget so a view impl can easily provide its container widget. 
 */
public interface GoodbyeView extends IsWidget{
	void setName(String helloName);
}
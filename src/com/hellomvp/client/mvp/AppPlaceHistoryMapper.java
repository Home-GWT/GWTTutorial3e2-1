package com.hellomvp.client.mvp;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.hellomvp.client.place.GoodbyePlace;
import com.hellomvp.client.place.HelloPlace;

/**
 * Интерфейс 'PlaceHistoryMapper' используется для подключения всех <страниц>, о которых 'PlaceHistoryHandler' должен знать.
 * Это делается либо с помощью аннотации 'WithTokenizers', либо расширяем через 'PlaceHistoryMapperWithFactory' и создаем отдельный 'TokenizerFactory'.
 */
@WithTokenizers( { HelloPlace.Tokenizer.class, GoodbyePlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {}

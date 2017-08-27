package com.pyesmeadow.george.moneymanager.util;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * A reusable class that handles managing a list of objects and calling event handlers when
 * new objects are added or removed.
 *
 * @param <T> the type of objects to should manage
 */
public class ObjectManagerWithListeners<T> implements Iterable<T> {

	private List<T> objectList = new ArrayList<>();

	private List<ListEventHandler> listEventHandlers = new ArrayList<>();

	public void add(T object)
	{
		objectList.add(object);

		listEventHandlers.forEach(listEventHandler ->
		{
			listEventHandler.onObjectListChange();
			listEventHandler.onAddObject(object);
		});
	}

	public boolean remove(T object)
	{
		if (!objectList.remove(object))
		{
			return false;
		}

		listEventHandlers.forEach(listEventHandler ->
		{
			listEventHandler.onObjectListChange();
			listEventHandler.onRemoveObject(object);
		});

		return true;
	}

	@Override
	public void forEach(Consumer<? super T> action)
	{
		objectList.forEach(action);
	}

	@NotNull
	@Override
	public Iterator<T> iterator()
	{
		return objectList.iterator();
	}

	public void registerListEventHandler(ListEventHandler listEventHandler)
	{
		listEventHandlers.add(listEventHandler);
	}

	public boolean unregisterListEventHandler(ListEventHandler listEventHandler)
	{
		return listEventHandlers.remove(listEventHandler);
	}

	public interface ListEventHandler<T> {

		default void onAddObject(T object)
		{
		}

		default void onRemoveObject(T object)
		{
		}

		default void onObjectListChange()
		{
		}
	}
}

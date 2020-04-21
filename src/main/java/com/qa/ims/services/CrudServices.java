package com.qa.ims.services;

import java.util.List;

public interface CrudServices<T> {

	public List<T> readAll();

	T create(T t);

	T update(T t);

	public void delete(Object t);

}

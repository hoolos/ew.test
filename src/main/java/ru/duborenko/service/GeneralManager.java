/**
 * 
 */
package ru.duborenko.service;

import java.util.List;

/**
 * Общий менеджер обьетков
 * 
 * @author MaxD
 *
 */
public interface GeneralManager<T> {
	/**
	 * Сохранине обьекта
	 * 
	 * @param domainObject
	 *            обьект
	 */
	public void save(T domainObject);

	/**
	 * Получине по идетификатору
	 * 
	 * @param pk
	 *            идентификатор
	 * @return обьект
	 */
	public T getById(Long pk);

	/**
	 * 
	 * @param nameQueryName
	 *            получение обьектов по именованому запросу
	 * @param params
	 * @return
	 */
	public List<T> getByNamedQuery(String nameQueryName, Object... params);
}

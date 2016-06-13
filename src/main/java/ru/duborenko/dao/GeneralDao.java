/**
 * 
 */
package ru.duborenko.dao;

import java.util.List;

/**
 * Дао общего назначения
 * 
 * @author MaxD
 *
 */
public interface GeneralDao<T> {
	/**
	 * охраняем обьект
	 * 
	 * @param domainObject
	 *            доменный обьект
	 */
	public void save(T domainObject);

	/**
	 * Удаление обьекта
	 * 
	 * @param domainObject
	 *            доменный обьект
	 */
	public void remove(T domainObject);

	/**
	 * Получение обьекта по ключу
	 * 
	 * @param primaryKey
	 *            ключ
	 * @return обьект
	 */
	public T get(Long primaryKey);

	/**
	 * Выполнение именованного запроса
	 * 
	 * @param namedQuery
	 *            именованный запрос
	 * @param params
	 *            параметры
	 * @return обьекты
	 */
	public List<T> getByNamedQuery(String namedQuery, Object... params);
}

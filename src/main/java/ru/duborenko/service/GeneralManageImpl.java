/**
 * 
 */
package ru.duborenko.service;

import java.util.List;

import ru.duborenko.dao.GeneralDao;

/**
 * 
 * @author MaxD
 *
 */
public class GeneralManageImpl<T, D extends GeneralDao<T>> implements
		GeneralManager<T> {
	/**
	 * Дао обьектоd
	 */
	private D dao;

	/**
	 * {@inheritDoc}
	 */
	public T getById(Long pk) {

		return dao.get(pk);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<T> getByNamedQuery(String nameQueryName, Object... params) {

		return dao.getByNamedQuery(nameQueryName, params);
	}

	/**
	 * {@inheritDoc}
	 */
	public void save(T domainObject) {
		dao.save(domainObject);

	}

	/**
	 * @return the dao
	 */
	public D getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(D dao) {
		this.dao = dao;
	}

}

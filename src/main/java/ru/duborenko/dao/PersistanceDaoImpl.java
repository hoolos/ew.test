/**
 * 
 */
package ru.duborenko.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.util.Assert;

/**
 * Реализация дао бд
 * 
 * @author MaxD
 *
 */
public class PersistanceDaoImpl<T> implements GeneralDao<T> {
	/**
	 * Класс персистентного обькта
	 */
	private Class<T> persistanceClass;
	/**
	 * SessionFactory для создания hiberante сессий
	 */
	private SessionFactory sessionFactory;

	/**
	 * Констуктор
	 * 
	 * @param persistanceClass
	 *            класс персистентного обекта
	 */
	public PersistanceDaoImpl(Class<T> persistanceClass) {
		this.persistanceClass = persistanceClass;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<T> getByNamedQuery(String namedQuery, Object... params) {
		Assert.hasLength(namedQuery);
		Query currentQuery = sessionFactory.getCurrentSession().getNamedQuery(
				namedQuery);
		Assert.notNull(currentQuery, "NamedQuery is null for " + namedQuery);
		if (params != null) {
			int j = 0;
			for (int i = 0; i < params.length; i++) {
				Object arg = params[i];
				if (arg instanceof Collection) {
					currentQuery.setParameterList(":list" + j,
							(Collection<?>) arg);
					j++;
				} else if (arg instanceof Object[]) {
					currentQuery.setParameterList(":list" + j,
							(Collection<?>) arg);
					j++;
				} else {

					currentQuery.setParameter(i, arg);

				}
			}
		}
		return currentQuery.list();
	}

	/**
	 * {@inheritDoc}
	 */
	public void save(T domainObjec) {
		sessionFactory.getCurrentSession().saveOrUpdate(domainObjec);

	}

	/**
	 * {@inheritDoc}
	 */
	public void remove(T domainObject) {
		sessionFactory.getCurrentSession().delete(domainObject);

	}

	/**
	 * {@inheritDoc}
	 */
	public T get(Long primaryKey) {
		return sessionFactory.getCurrentSession().get(getPersistanceClass(),
				primaryKey);

	}

	/**
	 * {@inheritDoc}
	 */
	public Class<T> getPersistanceClass() {

		return persistanceClass;
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}

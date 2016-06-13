/**
 * 
 */
package ru.duborenko.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import ru.duborenko.entity.Note;
import ru.duborenko.entity.NoteTag;

/**
 * Реализация дао заметок
 * 
 * @author MaxD
 *
 */
public class NotePersistanceDaoImpl extends
		PersistanceDaoImpl<Note<? extends NoteTag>> implements NoteDao {
	/**
	 * Конструктор
	 * 
	 * @param persistanceClass
	 *            класс доменного обьекта
	 */
	public NotePersistanceDaoImpl(
			Class<Note<? extends NoteTag>> persistanceClass) {
		super(persistanceClass);

	}

	/**
	 * {@inheritDoc}
	 */
	public <T extends NoteTag> List<Note<T>> findNoteByTagAndHeader(T tag,
			String header) {
		Criteria creteria = getSessionFactory().getCurrentSession()
				.createCriteria(getPersistanceClass());
		if (tag != null) {
			creteria.add(Restrictions.eq("tag", tag));

		}
		if (header != null) {
			creteria = creteria.add(Restrictions.like("header", "%" + header
					+ "%"));

		}
		return creteria.list();
	}
}

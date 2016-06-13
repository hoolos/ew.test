/**
 * 
 */
package ru.duborenko.dao;

import ru.duborenko.entity.NoteTag;

/**
 * Реализация дао тэгов
 * 
 * @author MaxD
 *
 */
public class NoteTagPersistanceDaoImpl extends PersistanceDaoImpl<NoteTag>
		implements NoteTagDao {
	/**
	 * Конструктор
	 * 
	 * @param persistanceClass
	 */
	public NoteTagPersistanceDaoImpl(Class<NoteTag> persistanceClass) {
		super(persistanceClass);

	}

}

/**
 * 
 */
package ru.duborenko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ru.duborenko.dao.NoteDao;
import ru.duborenko.entity.Note;
import ru.duborenko.entity.NoteTag;

/**
 * Реализация менеджера заметок
 * 
 * @author MaxD
 *
 */
@Component("noteManager")
public class NoteManagerImpl extends
		GeneralManageImpl<Note<? extends NoteTag>, NoteDao> implements
		NoteManager {
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Autowired
	@Qualifier("noteDao")
	public void setDao(NoteDao dao) {

		super.setDao(dao);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Note<? extends NoteTag>> getAllNotes() {
		return getDao().getByNamedQuery("getAllNotes");
	}

	/**
	 * {@inheritDoc}
	 */
	public <T extends NoteTag> List<Note<T>> getNoteByTagAndHeader(T tag,
			String header) {
		return getDao().findNoteByTagAndHeader(tag, header);

	}
}

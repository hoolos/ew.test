/**
 * 
 */
package ru.duborenko.dao;

import java.util.List;

import ru.duborenko.entity.Note;
import ru.duborenko.entity.NoteTag;

/**
 * Дао заметок
 * 
 * @author MaxD
 *
 */
public interface NoteDao extends GeneralDao<Note<? extends NoteTag>> {
	/**
	 * Поиск заметок по тэгу и заголовку
	 * 
	 * @param tag
	 *            тэг
	 * @param header
	 *            заголовок
	 * @return список заметок
	 */
	public <T extends NoteTag> List<Note<T>> findNoteByTagAndHeader(T tag,
			String header);
}

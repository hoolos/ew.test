/**
 * 
 */
package ru.duborenko.service;

import java.util.List;

import ru.duborenko.entity.Note;
import ru.duborenko.entity.NoteTag;

/**
 * Менеджер заметок
 * 
 * @author MaxD
 *
 */
public interface NoteManager extends GeneralManager<Note<? extends NoteTag>> {
	/**
	 * Получение все заметок
	 * 
	 * @return заметки
	 */
	public List<Note<? extends NoteTag>> getAllNotes();

	/**
	 * Получение заметок по тэгу и заголовку
	 * 
	 * @param tag
	 *            тэг
	 * @param header
	 *            заголовок
	 * @return заметки
	 */
	public <T extends NoteTag> List<Note<T>> getNoteByTagAndHeader(T tag,
			String header);
}

/**
 * 
 */
package ru.duborenko.service;

import java.util.List;

import ru.duborenko.entity.NoteTag;

/**
 * @author MaxD
 *
 */
public interface NoteTagManager extends GeneralManager<NoteTag> {
	/**
	 * Получение всех тэгов
	 * 
	 * @return
	 */
	public List<NoteTag> getAllTags();
}

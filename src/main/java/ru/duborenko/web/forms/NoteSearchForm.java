/**
 * 
 */
package ru.duborenko.web.forms;

import ru.duborenko.entity.NoteTagEntity;

/**
 * Форма поиска заметки
 * 
 * @author MaxD
 *
 */
public class NoteSearchForm {

	private NoteTagEntity tag;

	/**
	 * @return the tag
	 */
	public NoteTagEntity getTag() {
		return tag;
	}

	/**
	 * @param tag
	 *            the tag to set
	 */
	public void setTag(NoteTagEntity tag) {
		this.tag = tag;
	}

	private String noteHeaderToFind;

	/**
	 * @return the noteHeaderToFind
	 */
	public String getNoteHeaderToFind() {
		return noteHeaderToFind;
	}

	/**
	 * @param noteHeaderToFind
	 *            the noteHeaderToFind to set
	 */
	public void setNoteHeaderToFind(String noteHeaderToFind) {
		this.noteHeaderToFind = noteHeaderToFind;
	}
}

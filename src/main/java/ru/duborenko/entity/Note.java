/**
 * 
 */
package ru.duborenko.entity;

/**
 * Заметка
 * 
 * @author MaxD
 *
 */
public interface Note<T extends NoteTag> {
	/**
	 * Заголовок
	 * 
	 * @return заголовок
	 */
	public String getHeader();

	/**
	 * Тело заметки
	 * 
	 * @return тело
	 */
	public String getBody();

	/**
	 * Заголовок
	 * 
	 * @return
	 */
	public T getTag();

	/**
	 * 
	 * @param header
	 *            заголовок
	 */
	public void setHeader(String header);

	/**
	 * 
	 * @param body
	 *            тело заметки
	 */
	public void setBody(String body);

	/**
	 * 
	 * 
	 * @param tag
	 *            тэг
	 */
	public void setTag(T tag);

}

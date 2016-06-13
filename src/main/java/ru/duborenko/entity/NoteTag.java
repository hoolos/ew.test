/**
 * 
 */
package ru.duborenko.entity;

/**
 * Тэг
 * 
 * @author MaxD
 *
 */
public interface NoteTag {
	/**
	 * Назание тэга
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * Описание тэга
	 * 
	 * @return
	 */
	public String getDescription();

	/**
	 * 
	 * @param name
	 *            название тэга
	 */
	public void setName(String name);

	/**
	 * 
	 * @param description
	 *            опиание тэга
	 */
	public void setDescription(String description);
}

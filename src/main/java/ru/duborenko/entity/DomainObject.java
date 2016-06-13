/**
 * 
 */
package ru.duborenko.entity;

/**
 * Домнный обьект приложения с long ключом
 * 
 * @author MaxD
 *
 */
public interface DomainObject {
	/**
	 * Первичный ключ
	 * 
	 * @return
	 */
	public Long getId();

	public void setId(Long id);
}

/**
 * 
 */
package ru.duborenko.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Общий предок дб обьектов
 * 
 * @author MaxD
 *
 */
@MappedSuperclass
public abstract class DomainAncestor implements DomainObject, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3028295335428967021L;
	/**
	 * Первичный ключ
	 */
	protected Long id;

	/**
	 * Первичный ключ
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_ID")
	public Long getId() {
		return id;
	}

	/**
	 * Первичный ключ
	 */
	public void setId(Long id) {
		this.id = id;
	}
}

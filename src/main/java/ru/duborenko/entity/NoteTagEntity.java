/**
 * 
 */
package ru.duborenko.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Тэг
 * 
 * @author MaxD
 *
 */
@Entity
@Table(name = "note_tag")
@NamedQueries({ @NamedQuery(name = "getAllTags", query = "from NoteTagEntity") })
public class NoteTagEntity extends DomainAncestor implements NoteTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8934367813385745136L;
	/**
	 * название
	 */
	private String name;

	private String description;

	/**
	 * @return the name
	 */
	@Column(name = "name")
	public String getName() {
		return name;
	}

	/**
	 * @return the description
	 */
	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}

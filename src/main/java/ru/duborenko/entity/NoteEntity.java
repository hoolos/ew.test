/**
 * 
 */
package ru.duborenko.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Заметка
 * 
 * @author MaxD
 *
 */
@Entity
@Table(name = "note")
@NamedQueries({ @NamedQuery(name = "getAllNotes", query = "from NoteEntity") })
public class NoteEntity extends DomainAncestor implements Note<NoteTagEntity> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2941456576197565529L;
	/**
	 * Заголовок
	 */
	private String header;
	/**
	 * Тело
	 */
	private String body;
	/**
	 * Тэг
	 */
	private NoteTagEntity tag;

	/**
	 * {@inheritDoc}
	 */
	@Column(name = "header")
	public String getHeader() {

		return header;
	}

	/**
	 * {@inheritDoc}
	 */
	@Column(name = "body")
	public String getBody() {
		return body;
	}

	/**
	 * {@inheritDoc}
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "note_tag_id")
	public NoteTagEntity getTag() {
		return tag;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setHeader(String header) {
		this.header = header;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setTag(NoteTagEntity tag) {

		this.tag = tag;
	}

}

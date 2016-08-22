package cn.tiger.entity.bbs;
// Generated 2016-5-25 12:13:56 by Hibernate Tools 3.5.0.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


/**
 * Node generated by hbm2java
 */
@Entity
//表名与类名不相同时重新定义表名.
@Table(name = "node")
//默认的缓存策略.
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Node implements java.io.Serializable {

	private Long id;
	private Section section;
	private String description;
	private Long topicCount;
	private String name;
	private int status;
	private Set<Topic> topics = new HashSet<Topic>(0);

	public Node() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="section_id")
	public Section getSection() {
		return this.section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	@Column(name="description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="topic_count")
	public Long getTopicCount() {
		return this.topicCount;
	}

	public void setTopicCount(Long topicCount) {
		this.topicCount = topicCount;
	}

	@Column(name="name",nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="status")
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@OneToMany(mappedBy = "node")
	public Set<Topic> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}

}

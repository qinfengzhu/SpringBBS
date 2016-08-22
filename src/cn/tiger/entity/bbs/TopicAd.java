package cn.tiger.entity.bbs;
// Generated 2016-6-3 15:51:46 by Hibernate Tools 3.5.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * TopicAd generated by hbm2java
 */
@Entity
@Table(name = "topic_ad")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TopicAd implements java.io.Serializable {

	private Long id;
	//private long topicId;
	private long agreeCount;
	private long dsagreeCount;
	private Topic topic;

	public TopicAd() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="agree_count")
	public long getAgreeCount() {
		return this.agreeCount;
	}

	public void setAgreeCount(long agreeCount) {
		this.agreeCount = agreeCount;
	}

	@Column(name="dsagree_count")
	public long getDsagreeCount() {
		return this.dsagreeCount;
	}

	public void setDsagreeCount(long dsagreeCount) {
		this.dsagreeCount = dsagreeCount;
	}
	
	@ManyToOne
	@JoinColumn(name="topic_id",unique=true)
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}
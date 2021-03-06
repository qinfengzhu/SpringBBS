package cn.tiger.entity.bbs;
// Generated 2016-5-25 12:13:56 by Hibernate Tools 3.5.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


/**
 * Section generated by hbm2java
 */
//�û�������ʾ����
@Entity
@Table(name = "badge_show")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class BadgeShow implements java.io.Serializable {

	private Long id;
	private Long userId;
	private Long badgeId;
	private Integer show_control;

	public BadgeShow() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="user_id")
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name="badge_id")
	public Long getBadgeId() {
		return badgeId;
	}

	public void setBadgeId(Long badgeId) {
		this.badgeId = badgeId;
	}

	@Column(name="show_control")
	public Integer getShow_control() {
		return show_control;
	}

	public void setShow_control(Integer show_control) {
		this.show_control = show_control;
	}

}

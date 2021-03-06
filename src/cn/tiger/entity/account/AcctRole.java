package cn.tiger.entity.account;
// Generated 2016-4-29 19:14:11 by Hibernate Tools 3.5.0.Final

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springside.modules.utils.reflection.ConvertUtils;

import com.google.common.collect.Lists;


/**
 * AcctRole generated by hbm2java
 */
@Entity
@Table(name = "ACCT_ROLE")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AcctRole implements java.io.Serializable {

	private Long id;
	private String name;
	//private List<AcctAuthority> authorityList = Lists.newArrayList();
	private List<AcctAuthority> authorityList = new ArrayList<AcctAuthority>();

	public AcctRole() {
	}
	
	public AcctRole(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false, unique = true)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * @JoinColumn(name = "ROLE_ID")  指定当前我这个类在表中的字段
	 * 
	 */
	/*
	 * inverseJoinColumns 反转
	 * 与role对应的那张表authority的字段
	 */
	@ManyToMany
	@JoinTable(name = "ACCT_ROLE_AUTHORITY", joinColumns = { @JoinColumn(name = "ROLE_ID") }, inverseJoinColumns = { @JoinColumn(name = "AUTHORITY_ID") })
	//默认懒加载(除非设定关联属性lazy=false),在访问第一个关联对象时加载所有的关联对象。会累计产生两条sql语句。
	@Fetch(FetchMode.SUBSELECT)
	//按id排序
	@OrderBy("id")
	//基于时间戳判定机制，，对于数据同步要求严格的情况，使用频繁 
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<AcctAuthority> getAuthorityList() {
		return authorityList;
	}

	public void setAuthorityList(List<AcctAuthority> authorityList) {
		this.authorityList = authorityList;
	}
	
	@Transient
	public String getAuthNames() {
		//[浏览用户, 修改用户, 浏览角色, 修改角色]
		//用list里所有的元素的名字拼成以逗号隔开的字符串
		return ConvertUtils.convertElementPropertyToString(authorityList, "name", ", ");
	}

	@Transient
	@SuppressWarnings("unchecked")
	public List<Long> getAuthIds() {
		return ConvertUtils.convertElementPropertyToList(authorityList, "id");
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}

package com.mall.common.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.io.Serializable;
import java.util.List;

/**
 * @author egan
 * @date 2019-07-09
 */
public class PageWrapper<T> implements Serializable{

	private Long pn;
	private Long ps;
	private Long total;
	private List<T> list;

    public PageWrapper() {
    }

    public PageWrapper(IPage page) {
		this(page, page.getRecords());
	}

	public PageWrapper(IPage page, List<T> list) {
		this.pn = page.getCurrent();
		this.ps = page.getSize();
		this.total = page.getTotal();
		this.list = list;
	}

	public PageWrapper(Query query, List<T> list) {
		this.pn = query.getPn().longValue();
		this.ps = query.getPs().longValue();
		this.total = query.getTotal().longValue();
		this.list = list;
	}

	public Long getPn() {
		return pn;
	}

	public void setPn(Long pn) {
		this.pn = pn;
	}

	public Long getPs() {
		return ps;
	}

	public void setPs(Long ps) {
		this.ps = ps;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}

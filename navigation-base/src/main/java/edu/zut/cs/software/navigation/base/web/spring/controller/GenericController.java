package edu.zut.cs.software.navigation.base.web.spring.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zut.cs.software.navigation.base.domain.BaseEntity;
import edu.zut.cs.software.navigation.base.service.GenericManager;

public abstract class GenericController<T extends BaseEntity, PK extends Serializable, M extends GenericManager<T, PK>>
		extends BaseController {
	protected PK id;
	protected M manager;
	protected T model;
	protected Page<T> page;

	protected Pageable pageable;
	protected int pageNumber = 0;
	protected int pageSize = 20;

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public T create(@RequestBody T model) {
		this.model = model;
		Date date = new Date();
		this.model.setDateCreated(date);
		this.model.setDateModified(date);
		this.model = this.manager.save(this.model);
		return this.model;
	}

	/**
	 * @param id
	 * @throws IOException
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public void delete(@PathVariable PK id) throws IOException {
		this.manager.delete(id);
	}

	/**
	 * 根据输入，返回分页结果中的当前页，包括当前页信息和其中的实体对象集合
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Page<T> get(@RequestParam(name = "page", defaultValue = "0") String pageNumber,
			@RequestParam(name = "limit", defaultValue = "20") String pageSize) {
		if (StringUtils.isNotBlank(pageNumber)) {
			this.pageNumber = Integer.valueOf(pageNumber) - 1;
		}
		if (StringUtils.isNotBlank(pageSize)) {
			this.pageSize = Integer.valueOf(pageSize);
		}
		this.pageable = PageRequest.of(this.pageNumber, this.pageSize, new Sort(Direction.ASC, "id"));
		this.page = this.manager.findAll(this.pageable);
		logger.info(this.page);
		return this.page;
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public T getOne(@PathVariable PK id) {
		return this.manager.findById(id);

	}

	/**
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public T update(@PathVariable PK id, @RequestBody T model) {
		model.setId(Long.valueOf(id.toString()));
		model.setDateModified(new Date());// 更新修改时间
		this.model = this.manager.save(model);
		return this.model;
	}

}
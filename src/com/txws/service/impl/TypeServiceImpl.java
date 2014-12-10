package com.txws.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.txws.dao.interfaces.ICommonDAO;
import com.txws.model.TypeTable;
import com.txws.service.interfaces.ITypeService;
@Service("typeService")

public class TypeServiceImpl implements ITypeService {

	@Resource(name = "commonDAO")
	private ICommonDAO commonDAO;
	
	@Override
	public void addType(TypeTable type) {
		commonDAO.save(type);
	}
}

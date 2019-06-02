package edu.zut.cs.software.navigation.offset.service;


import java.util.List;

import edu.zut.cs.software.navigation.admin.offset.domain.Offset;
import edu.zut.cs.software.navigation.base.service.GenericTreeManager;

public interface OffsetManager extends GenericTreeManager<Offset, Long>{

	List<Offset> findbyOffsetname(String name);
}

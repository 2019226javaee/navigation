package edu.zut.cs.software.navigation.location;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.location.domain.Routes;
import edu.zut.cs.software.navigation.admin.map.domain.Map;
import edu.zut.cs.software.navigation.base.service.GenericTreeManagerTestCase;

public class RoutesManagerTest extends GenericTreeManagerTestCase<Long, Routes, RoutesManager> {

	
	
	
	RoutesManager routesManager;

    public RoutesManagerTest() {
        super(Routes.class);
    }
    
    @Autowired
	public void setRoutesManager(RoutesManager routesManager) {
		this.routesManager = routesManager;
		this.manager = this.routesManager;
	}
    
    @Override
	public void setUp()  {
    	Routes routes = new Routes();
    	routes.setName("路线1");
    	routes.setStartLocation("北门");
		this.entity = this.manager.save(routes);
	}
    
    @Test
	public void findbyMapname() {
		List<Routes> result = this.routesManager.findbyName("路线1");
        assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("路线1", result.get(0).getName());
        
		
	}
}

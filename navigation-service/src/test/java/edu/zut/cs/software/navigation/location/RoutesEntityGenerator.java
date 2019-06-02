package edu.zut.cs.software.navigation.location;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.navigation.admin.location.domain.Locations;
import edu.zut.cs.software.navigation.admin.location.domain.Routes;
import edu.zut.cs.software.navigation.base.service.GenericGenerator;

public class RoutesEntityGenerator extends GenericGenerator {

	@Autowired
	RoutesManager routesManager;
	@Autowired
	LocationsManager locationsManager;

	@Test
	public void testRoutesGeneration() {
		for (int i = 0; i < 3; i++) {
			Routes routes = new Routes();
			routes.setName("routes_" + i);
			this.routesManager.save(routes);
			List<Routes> list = new ArrayList<Routes>();
			for (int j = 0; j < 3; j++) {
				Routes routes1 = new Routes();
				routes1.setName("routes1_" + i + "_" + j);
				routes1.setParent(routes);
				list.add(routes1);
			}
			this.routesManager.save(list);
		}
	}

	public void testLoactionGeneration(Routes routes) {
		for (int i = 1; i < 5; i++) {
			Locations location = new Locations();
			location.setName("location_" + i);
			location.setY(i);
			location.setX(i+1);
			location.setRoutes(routes);
			this.locationsManager.save(location);
		}
	}

	@Test
	public void test() {
		this.routesManager.findAll();
	}
}

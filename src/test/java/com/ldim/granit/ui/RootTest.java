package com.ldim.granit.ui;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ldim.granit.ui.model.Root;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ldim on 19.04.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testRoot.groovy"})
public class RootTest {

    @Autowired
    private Root root;
    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void rootProtoTest() throws IOException {
        Object labell = findSlaveHash(1,1);
        Object label2_1 = findSlaveHash(1,2);
        Object label2_2 = findSlaveHash(2,2);
        assert !labell.equals(label2_1);
        assert label2_1.equals(label2_2);
    }

    @Test
    public void rootControllerStatesTest() throws IOException {
        Map states = (Map) getControllerProperty(1, "states");
        assert states.size() == 2;
        states = (Map) getControllerProperty(2, "states");
        assert states.size() == 1;
        states = (Map) getControllerProperty(3, "states");
        assert states.size() == 2;
        assert root.getState(1, 1) != root.getState(3, 1);
        assert root.getState(1, 2) != root.getState(2, 2);
        assert root.getState(1, 2) != root.getState(3, 2);
    }

    @Test
    public void rootStateSlavesTest() throws IOException {
        List<Map> list = (List)getStateProperty(1, 1, "slaves");
        assert list.size() == 3;
        list = (List)getStateProperty(1, 2, "slaves");
        assert list.size() == 2;
        list = (List)getStateProperty(2, 2, "slaves");
        assert list.size() == 1;
        list = (List)getStateProperty(3, 1, "slaves");
        assert list.size() == 1;
        list = (List)getStateProperty(3, 2, "slaves");
        assert list.size() == 1;
    }

    @Test
    public void rootControllersTest() throws IOException {
        Map map = (Map) getRootProperty("controllers");
        assert map.size() == 3;
        assert root.getController(1) != null;
        assert root.getController(2) != null;
        assert root.getController(3) != null;
        assert root.getController(4) == null;
    }

    private Object findSlaveHash(int controllerId, int code) throws IOException {
        List<Map> list = (List)getStateProperty(controllerId, code, "slaves");
        return list.stream().findFirst().orElse(new HashMap()).get("hash");
    }

    private Object findSlaveHashByKV(int controllerId, int code, Object key , Object value) throws IOException {
        List<Map> list = (List)getStateProperty(controllerId, code, "slaves");
        return list.stream().filter(e -> e.get(key).equals(value)).findFirst().orElse(new HashMap()).get("hash");
    }

    private Object getStateProperty(int controllerId, int code, String name) throws IOException {
        Map<String, Object> map = mapper.readValue(root.getState(controllerId, code).toString(), new TypeReference<Map<String,Object>>(){});
        return map.get(name);
    }

    private Object getControllerProperty(int controllerId, String name) throws IOException {
        Map<String, Object> map = mapper.readValue(root.getController(controllerId).toString(), new TypeReference<Map<String,Object>>(){});
        return map.get(name);
    }

    private Object getRootProperty(String name) throws IOException {
        Map<String, Object> map = mapper.readValue(root.toString(), new TypeReference<Map<String,Object>>(){});
        return map.get(name);
    }
}

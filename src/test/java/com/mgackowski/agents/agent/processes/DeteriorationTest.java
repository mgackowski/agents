package com.mgackowski.agents.agent.processes;

import static org.mockito.Mockito.when;

import java.util.Map;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.mgackowski.agents.agent.needs.NeedLevels;
import com.mgackowski.agents.agent.traits.Traits;
import com.mgackowski.agents.needs.Need;

import junit.framework.TestCase;

public class DeteriorationTest extends TestCase {
	
	private static float CHANGE_DIFF = -5f;
	private static float INITIAL = 50f;
	
	private enum NeedName {
		TEST_NEED_1,
		TEST_NEED_2
	}
	
	private Map<NeedName, Float> needMap;
	
	@Mock
	private NeedLevels needs;
	
	@Mock
	private Traits traits;
	
	@InjectMocks
	private Deterioration subject;

	public void setUp() {
		
		needMap.put(NeedName.TEST_NEED_1, INITIAL);
		
		MockitoAnnotations.initMocks(this);
		
		needs = Mockito.mock(NeedLevels.class);
		
		when(needs.getNeedMap()).thenReturn(needMap);
		when(needs.change(NeedName.TEST_NEED_1, CHANGE_DIFF)).then(new Answer() {
			public Object answer(InvocationOnMock invocation) throws Throwable {
				float oldValue = needMap.get(NeedName.TEST_NEED_1);
				float newValue = oldValue + CHANGE_DIFF;
				needMap.put(NeedName.TEST_NEED_1, newValue);
				return newValue;
			}	
		});
		
		subject = new Deterioration(needs, traits);
	}
	
	public void testDeterioration_tick_basicMechanism() {
		
		float deterioratedNeed = INITIAL + CHANGE_DIFF;
		
		subject.tick();
		
		assertEquals(deterioratedNeed, needMap.get(NeedName.TEST_NEED_1));
		
	}
	
	public void cleanup() {
		
	}
	
}

package Lab1;

import java.util.Random;

import Lab1.Environment.LocationState;

public class AgentProgram {

	public Action execute(Percept p) {
		if (p.getLocationState() == LocationState.DIRTY) {
			return Environment.SUCK_DIRT;
		}
		return randomAction(Environment.MOVE_LEFT, Environment.MOVE_RIGHT, Environment.MOVE_UP, Environment.MOVE_DOWN);
//		} else if (p.getAgentLocation() == Environment.LOCATION_A) {
//			return randomAction(Environment.MOVE_RIGHT, Environment.MOVE_DOWN);
//		} else if (p.getAgentLocation() == Environment.LOCATION_B) {
//			return randomAction(Environment.MOVE_LEFT, Environment.MOVE_DOWN);
//		} else if (p.getAgentLocation() == Environment.LOCATION_C) {
//			return randomAction(Environment.MOVE_UP, Environment.MOVE_LEFT);
//		} else {
//			return randomAction(Environment.MOVE_UP, Environment.MOVE_RIGHT);
//		}
	}

	public Action randomAction(Action actionA, Action actionB, Action actionC, Action actionD) {
		int random = 1 + (int) (Math.random() * ((4 - 1) + 1));
		if (random == 1)
			return actionA;
		if (random == 2)
			return actionB;
		if (random == 3)
			return actionC;
		return actionD;
	}
}

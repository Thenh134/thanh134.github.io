package agent;

import java.util.Random;

public class TestSimpleReflexAgent {
	public static void main(String[] args) {
		Environment env = new Environment(Environment.LocationState.CLEAN, Environment.LocationState.DIRTY,
				Environment.LocationState.DIRTY, Environment.LocationState.DIRTY);
		Agent agent = new Agent(new AgentProgram());
		env.addAgent(agent, Environment.LOCATION_B);

		env.stepUntilDone();
	}
}

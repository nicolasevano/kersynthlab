
package kernel;

import java.util.Map;

public interface Module extends Subject, HorlogeObserver {
	Map<String,InPort> getInPorts();

	Map<String,OutPort> getOutPorts();

}

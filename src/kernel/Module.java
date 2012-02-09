
package kernel;

import java.util.Map;

interface Module extends Subject, HorlogeObserver {
	Map<String,InPort> getInPorts();

	Map<String,OutPort> getOutPorts();

}

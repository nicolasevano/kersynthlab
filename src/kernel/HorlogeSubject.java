
package kernel;

public interface HorlogeSubject {
  void tick() ;

  void addModuleObserver(HorlogeObserver toAdd) ;

  void removeModuleObserver(HorlogeObserver toRemove) ;

}

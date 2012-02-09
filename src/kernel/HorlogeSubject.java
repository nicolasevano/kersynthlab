
package kernel;

interface HorlogeSubject {
  void tick() ;

  void addModuleObserver(HorlogeObserver toAdd) ;

  void removeModuleObserver(HorlogeObserver toRemove) ;

}

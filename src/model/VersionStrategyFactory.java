package model;


public class VersionStrategyFactory {
	

	public VersionsStrategy createStrategy(String strategy) {
		
		if (strategy.equals("Volatile")) {
			return new VolatileVersionStrategy();
		} else if (strategy.equals("Stable")) {
			return new StableVersionStrategy();
		}
		return null;
	}
}

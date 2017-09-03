/**
 * 
 */
package cz.unicorn.tga.tractor.model.enumeration;

/**
 * State of concrete car
 * 
 * @author DZCJS9F
 *
 */
public enum CarState {
	NEW, REGISTRED, LENDED, BROKEN, IN_GARAGE, DISABLED;

	public static CarState defaultState() {
		return NEW;
	}

	public static CarState parseType(final String type) {
		for (final CarState t : CarState.values()) {
			if (t.name().equalsIgnoreCase(type)) {
				return t;
			}
		}

		return null;
	}
}

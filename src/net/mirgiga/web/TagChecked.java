
package net.mirgiga.web;

import java.util.Collection;

public class TagChecked {
	  public static String contains(Collection<?> coll, Object o) {
		    return (coll.contains(o)?"checked":"");
		  }
}

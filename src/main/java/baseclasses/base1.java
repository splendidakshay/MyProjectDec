package baseclasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class base1 {
public static void main(String[] args) {
	ArrayList ar= new ArrayList();
	ar.add(5);
	ar.add("lkjgg");
	ar.add(5.0);
	ar.add(true);
	ar.add(2, "kk");
	//System.out.println(ar);
	//System.out.println(ar.isEmpty());
	Iterator itr = ar.iterator();

	while(itr.hasNext()) {
		System.out.println(itr.next());
		Thread.sleep(2000);

	}
	System.out.println("before clearing");
	System.out.println("size= "+ar.size());
	System.out.println(ar.contains(5));;System.out.println("clearing arraylist......");
	System.out.println("After reversing....");
	Collections.reverse(ar);
	System.out.println(ar);
	}
	}

}
}

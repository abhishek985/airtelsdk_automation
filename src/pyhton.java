import java.io.IOException;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class pyhton {

public static void main(String[] args) throws IOException {
	
		PythonInterpreter interpreter = new PythonInterpreter();
		interpreter.execfile("getdata.py");
		PyObject str = interpreter.eval("repr(getmeminfo('tv.airtel.visionsample'))");
		System.out.println(str.toString());

	}
}
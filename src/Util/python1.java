package Util;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class python1 {

	public String python()
	{
		PythonInterpreter interpreter = new PythonInterpreter();
		interpreter.execfile("getdata1.py");
		PyObject str = interpreter.eval("repr(getmeminfo('tv.airtel.visionsample'))");
		//	PyObject str1 = interpreter.eval("repr(getcpucores())");	
		String n=str.toString().substring(1,str.toString().length()-1);
		
		
		return n;
	}
}

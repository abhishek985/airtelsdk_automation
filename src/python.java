import java.io.IOException;

import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class python {

	public static void main(String[] args) throws IOException, ParseException {

		PythonInterpreter interpreter = new PythonInterpreter();
		interpreter.execfile("getdata.py");
		PyObject str = interpreter.eval("repr(getmeminfo('tv.airtel.visionsample'))");
		System.out.println(str.toString());
		String n=str.toString().substring(1,str.toString().length()-1);
		//System.out.println(n);

		JSONObject jsonObj = new JSONObject(n);
		//System.out.println(jsonObj.get("Native_Heap_Free"));

		int Native_Heap_Free=	(int)jsonObj.get("Native_Heap_Free");
		int Native_Heap_Alloc= (int)jsonObj.get("Native_Heap_Alloc");
		int Native_Pss=(int)jsonObj.get("Native_Pss");
		int Total_Pss=(int)jsonObj.get("Total_Pss");
		int Total_Heap_Alloc=(int)jsonObj.get("Total_Heap_Alloc");
		int Total_Heap_Free=(int)jsonObj.get("Total_Heap_Free");


		System.out.println(Total_Heap_Free +" "+ Total_Heap_Free +" "+Native_Heap_Alloc+" "+Native_Pss+" "+Total_Heap_Alloc+" "+Total_Pss);


	}
}
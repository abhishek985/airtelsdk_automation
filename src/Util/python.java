package Util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class python {

	public  void script() throws IOException, ParseException {

		
		PythonInterpreter interpreter = new PythonInterpreter();
		interpreter.execfile("getdata1.py");
		PyObject str = interpreter.eval("repr(getmeminfo('tv.airtel.visionsample'))");
		
	    //	PyObject str1 = interpreter.eval("repr(getcpucores())");
		

		String n=str.toString().substring(1,str.toString().length()-1);
		//String n1=str1.toString().substring(1,str1.toString().length()-1);
		System.out.println(n);
		//System.out.println(n1);
		
		try {
		JSONObject jsonObj = new JSONObject(n);

		int Native_Heap_Free=	(int)jsonObj.get("Native_Heap_Free");
		int Native_Heap_Alloc= (int)jsonObj.get("Native_Heap_Alloc");
		int Native_Pss=(int)jsonObj.get("Native_Pss");
		int Total_Pss=(int)jsonObj.get("Total_Pss");
		int Total_Heap_Alloc=(int)jsonObj.get("Total_Heap_Alloc");
		int Total_Heap_Free=(int)jsonObj.get("Total_Heap_Free");

//		JSONObject cpu = new JSONObject(n1);
//		String arr=cpu.get("CPU").toString();
//		String s=arr.substring(1,arr.toString().length()-1);
//		System.out.println(s);
//		String cpuinfo[]=s.split(",");
//		String CPU_0=cpuinfo[0];
//		String CPU_1=cpuinfo[1];
//		String CPU_2=cpuinfo[2];
//		String CPU_3=cpuinfo[3];
		
		//System.out.println(Total_Heap_Free +" "+ Native_Heap_Free +" "+Native_Heap_Alloc
		//		+" "+Native_Pss+" "+Total_Heap_Alloc+" "+Total_Pss+" ");

		File file = new File("file.html");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		new Htmlfilewriter().write(bw, Native_Heap_Free, Total_Heap_Free,
				Native_Heap_Alloc, Native_Pss, Total_Heap_Alloc, Total_Pss);
		//,CPU_0,CPU_1,CPU_2,CPU_3);
		}catch(Exception e){System.out.println(e);}
		
	}
}
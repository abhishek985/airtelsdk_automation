import java.io.BufferedReader;
import java.io.InputStreamReader;

public class File {
	public static void main(String args[]) throws Exception
	{			
		String line="";
//		String cmd = "/Users/b0206672/Library/Android/sdk/platform-tools/adb shell dumpsys gfxinfo tv.airtel.sampletv "
//				+ "|grep -E \"Total frames rendered|Janky frames|"
//				+ "50th percentile|90th percentile|95th percentile|"
//				+ "99th percentile|Number Missed Vsync|Number High input latency|"
//				+ "Number Slow UI thread|Number Slow bitmap uploads: |Number Slow issue draw commands:\""; 
		
		String cmd="netstat";
		Runtime r=Runtime.getRuntime();
		Process p = r.exec(cmd);

		BufferedReader buf = new BufferedReader(new InputStreamReader(p.getInputStream()));
		while ((line=buf.readLine())!=null) {
		System.out.println(line);
		}
		
		//PrintStream printStream = new PrintStream(new FileOutputStream("/Users/b0206672/Desktop/logs.txt"));
		//System.setOut(printStream);
		//File f = new File();	
		}
}

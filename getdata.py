import re
import subprocess
import sys
import time
from subprocess import check_output, CalledProcessError

cmp = "tv.airtel.visionsample/.activity.MainActivity"
pname = "tv.airtel.visionsample"
device_id = "emulator-5554"




# Check IF Android Device is connected
def check_device(args):
    try:
        adb_ouput = check_output(["adb","devices"])
        if args in adb_ouput:
            return "Device is Connected"
        else:
            return "Device not Connected"
    except CalledProcessError as e:
        return e.returncode


def getmeminfo(pname):
    line_dict = {}
    ls = subprocess.Popen(["adb", "shell", "dumpsys", "meminfo", pname], stdout=subprocess.PIPE)
    out = ls.stdout.readlines()
    for line in out:
        if re.search("Native Heap", line):
            line = line.strip("\n")
            line_array = line.split(" ")
            line_array = ' '.join(line_array).split()
            line_dict["Native_Pss"] = line_array[2]
            line_dict["Native_Heap_Alloc"] = line_array[-2]
            line_dict["Native_Heap_Free"] = line_array[-1]

        if re.search("TOTAL", line):
            line = line.strip("\n")
            line_array = line.split(" ")
            line_array = ' '.join(line_array).split()
            line_dict["Total_Pss"] = line_array[1]
            line_dict["Total_Heap_Alloc"] = line_array[-2]
            line_dict["Total_Heap_Free"] = line_array[-1]

    if line_dict:
        return line_dict
    return "App not started.Unable to fetch meminfo"


def getcpuinfo(pname):
    lm = subprocess.Popen(["adb", "shell", "dumpsys", "cpuinfo", "| grep -i", pname], stdout=subprocess.PIPE)
    out = lm.stdout.readlines()
    for line in out:
        return line.strip("\n")
    else:
        return "App not started.Unable to fetch cpuinfo"


##def main():
##    f1 = check_device(sys.argv[1])
##    f2 = getmeminfo(sys.argv[2])
##    f3 = getcpuinfo("tv.airtel.visionsample")
##    return f1,f2,f3
##
##if __name__ == "__main__":
##    main()



# def main():
#     print("Start Measuring")
#     print check_device(device_id)
#     print getmeminfo(pname)
#
#
# if __name__ == "__main__":
#     main()

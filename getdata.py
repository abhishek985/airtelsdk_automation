import re
import subprocess
import sys
import time
from subprocess import check_output, CalledProcessError
import json

cmp = "tv.airtel.visionsample/.activity.MainActivity"
pname = "tv.airtel.visionsample"
device_id = "emulator-5554"


# Check IF Android Device is connected
def check_device(args):
    try:
        adb_ouput = check_output(["adb", "devices"])
        if args in adb_ouput:
            return "Device is Connected"
        else:
            return "Device not Connected"
    except CalledProcessError as e:
        return e.returncode


def getmeminfo(pname):
    line_dict = {}
    ls = subprocess.Popen(["adb", "shell", "dumpsys", "meminfo", pname, " | grep -E", "'Native Heap|TOTAL' -A 2"],
                          stdout=subprocess.PIPE)
    out = ls.stdout.readlines()
    for line in out:
        if re.search("Native Heap", line):
            line = line.strip("\n")
            line_array = line.split(" ")
            line_array = " ".join(line_array).split()
            line_dict["Native_Pss"] = int(line_array[2])
            line_dict["Native_Heap_Alloc"] = line_array[-2]
            line_dict["Native_Heap_Free"] = int(line_array[-1])

<<<<<<< HEAD
        if re.search("TOTAL", line):
            line = line.strip("\n")
            line_array = line.split(" ")
            line_array = " ".join(line_array).split()
            line_dict["Total_Pss"] = int(line_array[1])
            line_dict["Total_Heap_Alloc"] = line_array[-2]
            line_dict["Total_Heap_Free"] = int(line_array[-1])
=======
            for line_sub in out:
                if re.search("TOTAL", line_sub):
                    line_sub = line_sub.strip("\n")
                    line_array = line_sub.split(" ")
                    line_array = " ".join(line_array).split()
                    line_dict["Total_Pss"] = int(line_array[1])
                    line_dict["Total_Heap_Alloc"] = int(line_array[-2])
                    line_dict["Total_Heap_Free"] = int(line_array[-1])
                    break
        break
>>>>>>> 9196c09aa1f0a96a95f08f92513ecc6ad1439dab

    if line_dict:
        return json.dumps(line_dict)
    return "App not started.Unable to fetch meminfo"


def getcpuinfo(pname):
    lm = subprocess.Popen(["adb", "shell", "dumpsys", "cpuinfo", "| grep -i", pname], stdout=subprocess.PIPE)
    out = lm.stdout.readlines()
    for line in out:
        return line.strip("\n")
    else:
        return "App not started.Unable to fetch cpuinfo"


def getcpucores():
    line_dict_cpu = {}
    try:
        for i in range(1, 5):
            lo = subprocess.Popen(["adb shell cat sys / devices / system / cpu / cpu" + str(i) +
                                   " / cpufreq / scaling_cur_freq"],
                                  stdout=subprocess.PIPE)
            out = lo.stdout.readlines()
            line_dict_cpu["CPU" + str(i)] = out
    except OSError:
        return "Unable to fetch CPU core details in Emulator"

    if line_dict_cpu:
        return line_dict_cpu
    return "App not started.Unable to fetch CPU Core"


print ("Complete")

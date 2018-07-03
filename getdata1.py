import re
import subprocess
from subprocess import check_output, CalledProcessError
import json
import os

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
    ls = subprocess.Popen(["adb", "shell", "dumpsys", "meminfo", pname, " | grep -E", "'Native Heap|TOTAL'"],
                          stdout=subprocess.PIPE)
    out = ls.stdout.readlines()
    for line in out:
        if re.search("Native Heap", line):
            line = line.strip("\n")
            line_array = line.split(" ")
            line_array = " ".join(line_array).split()
            line_dict["Native_Pss"] = int(line_array[2])
            line_dict["Native_Heap_Alloc"] = int(line_array[-2])
            line_dict["Native_Heap_Free"] = int(line_array[-1])

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

    if line_dict:
        return json.dumps(line_dict)
    return "App not started.Unable to fetch meminfo...."


def getcpuinfo(pname):
    lm = subprocess.Popen(["adb", "shell", "dumpsys", "cpuinfo", "| grep -i", pname], stdout=subprocess.PIPE)
    out = lm.stdout.readlines()
    for line in out:
        return line.strip("\n")
    else:
        return "App not started.Unable to fetch cpuinfo"


def getcpucores():
    line_cpu = []
    line_dict_cpu = {}

    try:
        cpu0 = os.popen('adb shell cat sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq')
        cpu1 = os.popen('adb shell cat sys/devices/system/cpu/cpu1/cpufreq/scaling_cur_freq')
        cpu2 = os.popen('adb shell cat sys/devices/system/cpu/cpu2/cpufreq/scaling_cur_freq')
        cpu3 = os.popen('adb shell cat sys/devices/system/cpu/cpu3/cpufreq/scaling_cur_freq')

        try:
            line_cpu.append(int(cpu0.read().strip('\r\n')))
            line_cpu.append(int(cpu1.read().strip('\r\n')))
            line_cpu.append(int(cpu2.read().strip('\r\n')))
            line_cpu.append(int(cpu3.read().strip('\r\n')))
        except:
            return "no devices/emulators found"

        if line_cpu:
            line_dict_cpu["CPU"] = line_cpu
        else:
            line_dict_cpu["CPU"] = 0

    except:
        return "Unable to fetch CPU core details"

    if line_dict_cpu:
        return json.dumps(line_dict_cpu)
    return "App not started.Unable to fetch CPU Core"

print ("Test Complete")

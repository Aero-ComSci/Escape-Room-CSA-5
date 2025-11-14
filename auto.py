from pynput.keyboard import Listener
import pyautogui
import time

start_flag = False
abort_flag = False

def on_press(key):
    global start_flag, abort_flag
    try:
        if key.char == 'm':
            start_flag = True
            return False
        if key.char == 'n':
            abort_flag = True
            return False
    except:
        pass

def wait_keys():
    print("Press m to start, n to quit")
    with Listener(on_press=on_press) as l:
        l.join()

def cmd(s):
    pyautogui.write(s)
    pyautogui.press('enter')
    time.sleep(0.0004)

def run_bot():
    for _ in range(10):
        cmd("p")
        cmd("t")
        cmd("r")
    cmd("q")

wait_keys()
if not abort_flag:
    run_bot()

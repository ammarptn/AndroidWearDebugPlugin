# AndroidWearDebugPlugin
This is android studio plugin that provide quick access to connect Android studio with real android wear device and give you ADB access on your watch.


version 1.0 :

##Instructions :

(install AndroidWearDebugPlugin.jar in your Android studio first)
 [AndroidWearDebugPlugin.jar](https://github.com/ammarptn/AndroidWearDebugPlugin/blob/master/AndroidWearDebugPlugin.jar)

On android wear
  1. Open setting on the watch and enable developer option
  2. Enable ADB debugging and Debuging over bluetooth.

On companion device
  3. Open ADB debuging on your devices.
  4. Open Android wear application
  5. Tap Gear icon on the top right
  6. In Debug over bluetooth section select device to debug and choose your android wear watch
  7. Enable Debug over bluetooth.
  8. Connect your devices with your computer.
  
On Android studio
  9. Click the android wear icon and you can access your watch via ADB
  10. Your android watch name will apper in ADB as "127.0.0.1:4444"
  11. Good luck!!
  
if it can't connect
  - check if your watch is enable ADB debugging
  - check if your ADB can see you companion device.
  - check if your companion devices enable debug over bluetooth.
  - check if your companion devices have ADB autorized
  - check if your ADB connect with only one device (see limitaion section) type "adb devices" to check.
  - check every step in instruction above.
  
  
##Limitation in version 1.0 :
If your ADB connect with two or more devices. it will unable to connect. Unplug other devices and left with the devices that you connect with android wear watch.
(im very busy to fix this. really sorry about that)

  



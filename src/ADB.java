
import com.intellij.util.EnvironmentUtil;


public class ADB {

  private static final String ANDROID_ENV_VAR_NAME = "ANDROID_HOME";
  private static final String ADB_RELATIVE_PATH = "/platform-tools/adb";

  private final CommandLine commandLine;


  public ADB(CommandLine commandLine) {
    this.commandLine = commandLine;

  }

  public boolean isInstalled() {
    String versionCommand = getCommand("version");
    return !commandLine.executeCommand(versionCommand).isEmpty();
  }

  public String isADBInstalled() {
    String versionCommand = getCommand("version");
    return commandLine.executeCommand(versionCommand);
  }


  private boolean connectDevice(String deviceIp) {
    String enableTCPCommand = getCommand("tcpip 5555");
    commandLine.executeCommand(enableTCPCommand);
    String connectDeviceCommand = getCommand("connect " + deviceIp);
    String connectOutput = commandLine.executeCommand(connectDeviceCommand);
    return connectOutput.contains("connected");
  }

  public String connectToWearOverBlueTooth() {

    String enableTCPCommand = getCommand("forward tcp:4444 localabstract:/adb-hub");
    String ForwordConnectOutput = commandLine.executeCommand(enableTCPCommand);

      String connectDeviceCommand = getCommand("connect 127.0.0.1:4444");
      String connectOutput = commandLine.executeCommand(connectDeviceCommand);
      if(connectOutput.contains("unable"))
      {
        return "Unable to connect to android wear<br>Check device authorize and android wear debug over bluetooth";
      }
      else
      {
        return "Android wear connected";
      }



  }

  private String getAdbPath() {
    String androidSdkPath = EnvironmentUtil.getValue(ANDROID_ENV_VAR_NAME);
    if (androidSdkPath == null) {
      return "";
    }
    return androidSdkPath + ADB_RELATIVE_PATH;
  }

  private String getCommand(String command) {
    return getAdbPath() + " " + command;
  }
}

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.ApplicationManager;

/**
 * Created by ammarptn on 10/21/2015.
 */
public class AndroidWearDebug extends AnAction {

    private static final NotificationGroup NOTIFICATION_GROUP =
            NotificationGroup.balloonGroup("Android Wear Debug tool");

    public void actionPerformed(AnActionEvent e) {
        ApplicationManager.getApplication().executeOnPooledThread(new Runnable() {
            public void run() {
                CommandLine cl = new CommandLine();
                ADB adb = new ADB(cl);

                showNotification("Android Wear Debug tool", adb.connectToWearOverBlueTooth()+"", NotificationType.INFORMATION);
                //showNotification("Android Wear Debug tool", adb.isADBInstalled(), NotificationType.INFORMATION);
            }
        });
    }
    private void showNotification(final String title, final String message,
                                  final NotificationType type) {
        ApplicationManager.getApplication().invokeLater(new Runnable() {
            @Override public void run() {
                Notification notification =
                        NOTIFICATION_GROUP.createNotification(title, message, type, null);
                Notifications.Bus.notify(notification);
            }
        });
    }
}

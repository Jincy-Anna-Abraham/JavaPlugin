package plugintest.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.TextConsole;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SampleHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public SampleHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
//		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
//		MessageDialog.openInformation(
//				window.getShell(),
//				"PluginTest",
//				"Hello, Eclipse world");
//		return null;
		
		//taking input
//		InputDialog dlg = new InputDialog(
//		          HandlerUtil.getActiveShellChecked(event), "Title",
//		          "Enter text", "Initial value", null);
//		      if (dlg.open() == Window.OK) {
//		        String input = dlg.getValue();
//		        IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
//
//		           IProject myWebProject = myWorkspaceRoot.getProject("MyWeb");
//		           // open if necessary
//		           if (myWebProject.exists() && !myWebProject.isOpen())
//		              myWebProject.open(null);
//		        System.out.println("Printing : "+input);
//		      }
				   
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager conMan = plugin.getConsoleManager();
		IConsole[] existing = conMan.getConsoles();
		StringBuilder string1 = new StringBuilder();
		for (int i = 0; i < existing.length; i++) {
		    try {
		    	TextConsole myconsole = (TextConsole) existing[i];
		        System.out.println(myconsole.getDocument().get());
		        string1.append(myconsole.getDocument().get());
		    } catch(Exception exc) {
		        exc.printStackTrace();
		    }
		}
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		MessageDialog.openInformation(window.getShell(),
				"PluginTest",
				string1.toString());
		      return null; 
	}
}

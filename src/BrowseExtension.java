import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.nlogo.api.Argument;
import org.nlogo.api.Command;
import org.nlogo.api.Context;
import org.nlogo.api.DefaultClassManager;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.LogoException;
import org.nlogo.api.PrimitiveManager;
import org.nlogo.core.Syntax;
import org.nlogo.core.SyntaxJ;

public class BrowseExtension extends DefaultClassManager {

	@Override
	public void load(PrimitiveManager arg0) throws ExtensionException {
		arg0.addPrimitive("browse-to", new BrowseTo());;
	}
	
	public static class BrowseTo implements Command {

		public Syntax getSyntax() {
			// TODO Auto-generated method stub
			return SyntaxJ.commandSyntax(new int[]{Syntax.StringType()});
		}

		@Override
		public void perform(Argument[] arg0, Context arg1) throws ExtensionException {
			URI uri = null;
			try {
				uri = new URI(arg0[0].getString());
			} catch (LogoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Desktop.getDesktop().browse(uri);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}	
		
		
	}

}
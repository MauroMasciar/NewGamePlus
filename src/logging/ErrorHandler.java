package logging;

import javax.swing.JOptionPane;

public class ErrorHandler {

    public static void handle(Exception e) {
        Logger.loguear(e.getMessage());
        JOptionPane.showMessageDialog(null, "Ha ocurrido un error.\nConsulta el archivo de logs.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

/*
	try {
	    gameDAO.save(game);
	} catch (Exception e) {
	    ErrorHandler.handle(e);
	}
*/

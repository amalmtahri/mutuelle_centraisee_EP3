module MutuelleCenta {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	requires javafx.base;
	requires java.desktop;
	requires junit;
	requires com.fasterxml.jackson.databind;
	requires com.fasterxml.jackson.core;
	requires bcrypt;
	requires com.hierynomus.sshj;
	
	//requires java.logging;
	requires java.mail;
	requires java.logging;
	requires log4j;
	
	
	opens com.mutuelle.application to javafx.graphics, javafx.fxml;
	
	opens com.mutuelle.application.views to javafx.graphics, javafx.fxml;
	exports com.mutuelle.application.views;
	exports com.mutuelle.application.models;
}

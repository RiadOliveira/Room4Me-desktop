package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import view.MainScreen;
import view.screens.ScreensName;

public class LoginController{
    
    @FXML
    private Button loginButton;

    @FXML
    private Button signUpButton;

    @FXML
    void login(ActionEvent event) {
        MainScreen.load(ScreensName.Search);
    }
    
    @FXML
    void signUp(ActionEvent event) {
        MainScreen.load(ScreensName.SignUp);
    }

    @FXML
    private Label escuro;
    //escuro.setStyle(escuro.getStyle()+"visibility: true");

}

/*
FuncionarioVO authfunvo = new FuncionarioVO();

	public void auth(ActionEvent event) throws Exception {

		FuncionarioBO bo = new FuncionarioBO();
		FuncionarioVO funvo = new FuncionarioVO();

		funvo.setNickName(usu.getText());
		funvo.setSenha(senha.getText());

		this.authfunvo = bo.autenticar(funvo);

		if (authfunvo == null) {
			usu.setStyle(usu.getStyle() + "-fx-border-color: #F40779;");
			senha.setStyle(senha.getStyle() + "-fx-border-color: #F40779;");
		} else {
			TelasPrincipal.load(telasNome.venda);
		}

	}

	public FuncionarioVO returnFuncionario(FuncionarioVO vo) {
		return (vo);
	}
}
*/
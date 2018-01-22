package controller.command;

import controller.command.commandImpl.*;

public enum CommandList {
    LOCALIZATION(new LocalizationCommand()),
    AUTHORIZATION(new AuthorizationCommand()),
    REGISTRATION(new RegistrationCommand()),
    LOG_OUT(new LogOutCommand()),
    CREATE_MASTER(new MasterCreationCommand()),
    UPDATE_MASTER(new UpdateMasterCommand()),
    MASTER_LIST(new MasterListCommand());

    private Command command;


    CommandList(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}

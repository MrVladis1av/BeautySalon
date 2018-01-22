package controller.command.commandImpl;

import controller.command.Command;
import controller.util.constants.Pages;
import dto.Master;
import services.factory.ServiceFactory;
import services.impl.MasterService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MasterListCommand implements Command {
    private MasterService masterService;

    public MasterListCommand() {
        masterService = ServiceFactory.getMasterService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Master> masterList = masterService.findAll();
        System.out.println(masterList);
        request.setAttribute("masters", masterList);
        return Pages.MASTER_LIST;
    }
}

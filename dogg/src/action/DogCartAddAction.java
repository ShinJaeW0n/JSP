package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DogCartAddAService;
import svc.DogCartAddService;
import vo.ActionForward;
import vo.Dog;

public class DogCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DogCartAddService dogCartAddAService = new DogCartAddService();
		int id = Integer.parseInt(request.getParameter("id"));
		Dog cartDog = dogCartAddAService.getCartDog(id);
		dogCartAddAService.addCart(request, cartDog);
		ActionForward forward = new ActionForward("dogCartList.dog", true);
		
		return forward;
	}

}

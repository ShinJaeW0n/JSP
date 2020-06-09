package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DogCartListServie;
import vo.ActionForward;
import vo.Cart;

public class DogCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DogCartListServie dogCartListService = new DogCartListServie();
		ArrayList<Cart> cartList = dogCartListService.getCartList(request);
		
		int totalMoney = 0;
		int money = 0;
		
		for(int i=0; i<cartList.size(); i++) {
			money = cartList.get(i).getPrice()*cartList.get(i).getQty();
			totalMoney +=money;
		}
		
		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("cartList", cartList);
		
		ActionForward forward = new ActionForward("dogCartList.jsp", false);
		return forward;
	}

}

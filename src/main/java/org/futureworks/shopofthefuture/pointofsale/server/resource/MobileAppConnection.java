package org.futureworks.shopofthefuture.pointofsale.server.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.futureworks.shopofthefuture.pointofsale.api.APIConnector;
import org.futureworks.shopofthefuture.pointofsale.api.JSONParser;
import org.futureworks.shopofthefuture.pointofsale.logic.PointOfSale;

@Path("mobileappconnection")
public class MobileAppConnection {

	private JSONParser parser;
	private APIConnector apiConnector;
	private PointOfSale logic;
	
	public MobileAppConnection(){
		this.logic = PointOfSale.getInstance();
		this.apiConnector = APIConnector.getInstance();
		this.parser = JSONParser.getInstance();
	}
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
	    
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes("application/x-www-form-encoded")
	public String shoppingList(@FormParam("shoppingCart") String shoppingCart){
		//Map<String, Integer> barcodes = parser.parseMobileShoppingCart();
		//while
		System.out.println(shoppingCart);
		System.out.println("MobileAppConnection : shoppingList()");
		logic.setNewShoppingList(parser.parseShoppingCart(shoppingCart));
		return shoppingCart;
	}
	
}
